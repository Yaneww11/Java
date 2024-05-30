package service;

import data.*;

import java.math.BigDecimal;
import java.util.*;

public class ClientServiceImpl extends MapGoodService {
    private ReceiptServiceImpl receiptService;

    public ClientServiceImpl(ReceiptServiceImpl receiptService) {
        this.receiptService = receiptService;
    }

    public void putGood(Client client, String nameGood, Shop shop){
        if (!client.getGoods().containsKey(nameGood)){
            client.getGoods().put(nameGood, new LinkedList<>());
        }
        if (!shop.getGoods().containsKey(nameGood)){
            System.out.println("Now dont have " +nameGood +" in " + shop.getName());
            return;
        }
        client.getGoods().get(nameGood).add(shop.getGoods().get(nameGood).peek());
    }

    public void putGood(Client client, String nameGood, int countGoods, Shop shop){
        if (countGoods < 1){
            return;
        }
        if (!shop.getGoods().containsKey(nameGood)){
            System.out.println("Now dont have " +nameGood +" in " + shop.getName());
            return;
        }

        Queue<GoodShop> shopItems = new PriorityQueue<>(shop.getGoods().get(nameGood));
        for (int i = 1; i <= countGoods; i++) {
            if (!client.getGoods().containsKey(nameGood)){
                client.getGoods().put(nameGood, new LinkedList<>());
            }
            client.getGoods().get(nameGood).add(shopItems.poll());
        }
    }
    public GoodShop removeGood(CanGetGoods objectWithMap, GoodShop goodShop){
        if (!objectWithMap.getGoods().containsKey(goodShop.getName())){
            throw new IllegalArgumentException(objectWithMap.getName() + " does`t have " + goodShop.getName());
        }
        GoodShop deletedGood = objectWithMap.getGoods().get(goodShop.getName()).remove();
        if (objectWithMap.getGoods().get(goodShop.getName()).isEmpty()){
            objectWithMap.getGoods().remove(goodShop.getName());
        }
        return deletedGood;
    }
    public Receipt buyGoods(Client client, Shop shop, Integer numberOfCashRegister){
        validateTransaction(client, shop, numberOfCashRegister);
        BigDecimal orderSum = getSumOfOrder(client, shop);
        Receipt receipt = createReceipt(client, shop, numberOfCashRegister, orderSum);
        this.receiptService.writeReceipt(receipt.getUuid().toString(), receipt);
        updateData(client, shop, orderSum);

        return receipt;
    }

    private void updateData(Client client, Shop shop, BigDecimal orderSum) {
        updateShopData(client, shop, orderSum);
        updateClientData(client, orderSum);
    }


    private static void updateClientData(Client client, BigDecimal orderSum) {
        client.setMoney(client.getMoney().subtract(orderSum));
    }

    private void updateShopData(Client client, Shop shop, BigDecimal orderSum) {
        shop.setCountReceipts(shop.getCountReceipts() + 1);
        shop.setTurnover(shop.getTurnover().add(orderSum));
        removeClientGoodsFromShop(client, shop);
    }

    private Receipt createReceipt(Client client, Shop shop, Integer numberOfCashRegister, BigDecimal orderSum) {
        Cashier cashier = getCashierAtCheckout(shop, numberOfCashRegister);
        Map<String, Queue<GoodShop>> clientGoods = deepCopy(client.getGoods());
        putGoodsToListFromMap(shop.getSoldGoods(), clientGoods);
        Receipt receipt = new Receipt(cashier, clientGoods, orderSum);
        return receipt;
    }
    public Map<String, Queue<GoodShop>> deepCopy(HashMap<String, Queue<GoodShop>> original)
    {
        HashMap<String, Queue<GoodShop>> copy = new HashMap<String, Queue<GoodShop>>();
        for (Map.Entry<String, Queue<GoodShop>> entry : original.entrySet())
        {
            copy.put(entry.getKey(),
                    new LinkedList<>(entry.getValue()));
        }
        return copy;
    }

    private BigDecimal getSumOfOrder(Client client, Shop shop) {
        BigDecimal orderSum = sumOfOrder(client, shop);
        if (!checkClientMoney(orderSum, client.getMoney())){
            throw new IllegalArgumentException("The client doesn`t have enough money");
        }
        return orderSum;
    }

    private void validateTransaction(Client client, Shop shop, Integer numberOfCashRegister){
        checkClientOrderIsNotEmpty(client);

        if (!checkValidCashRegister(shop, numberOfCashRegister)){
            throw new IllegalArgumentException("The value of "
                    + "the argument must be between 0 and  "
                    + (shop.getCountCashRegister() - 1)
                    + "! The argument is: "
                    + numberOfCashRegister);
        }
        checkEnoughCountOfGood(client, shop);
    }

    private void putGoodsToListFromMap(List<GoodShop> list, Map<String, Queue<GoodShop>> map){
        for (Queue<GoodShop> queue : map.values()) {
            list.addAll(queue);
        }
    }
    private void checkClientOrderIsNotEmpty(Client client){
        if(client.getGoods().isEmpty()){
            throw new IllegalArgumentException("The client doesn`t have nothing to buy");
        }
    }

    private boolean checkValidCashRegister(Shop shop, Integer numberOfCashRegister){
        int countCashRegister = shop.getCountCashRegister() - 1;
        return numberOfCashRegister >= 0 && numberOfCashRegister <= countCashRegister;
    }
    private void checkEnoughCountOfGood(Client client, Shop shop){
        Map<String, Queue<GoodShop>> goodsInShop = shop.getGoods();
        client.getGoods()
                .entrySet()
                .stream()
                .forEach(good -> {
                    String goodName = good.getKey();
                    if (!goodsInShop.containsKey(goodName)) {
                        throw new IllegalArgumentException("Don`t have enough "
                                + goodName);
                    }
                    int neededGoodCount = good.getValue().size() - goodsInShop.get(goodName).size();
                    if (neededGoodCount > 0){
                        throw new IllegalArgumentException("Don`t have enough "
                                + goodName
                                + "! Need "
                                + neededGoodCount);
                    }
                });
    }

    private BigDecimal sumOfOrder(Client client, Shop shop){
        return client.getGoods()
                .entrySet()
                .stream()
                .map(e -> {
                    BigDecimal sum = BigDecimal.ZERO;
                    Iterator<GoodShop> it = e.getValue().iterator();
                    while (it.hasNext()) {
                        sum = sum.add(it.next().sellingPrice());
                    }
                    return sum;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    private boolean checkClientMoney(BigDecimal orderSum, BigDecimal clientMoney){
        if (orderSum.compareTo(clientMoney) != -1){
            return false;
        }
        return true;
    }

    private void removeClientGoodsFromShop(Client client, Shop shop){
        for (Queue<GoodShop> queue: client.getGoods().values()){
            while (!queue.isEmpty()){
                GoodShop good = queue.poll();
                removeGood(shop, good);
            }
        }
        client.getGoods().clear();
    }

    private Cashier getCashierAtCheckout(Shop shop, int num){
        return shop.getCashRegisters().get(num);
    }

    public ReceiptServiceImpl getReceiptService() {
        return receiptService;
    }
}
