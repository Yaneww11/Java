import shop.CanBeSold;
import shop.Goods;
import shop.Vehicle;

public class Main {
    public static void main(String[] args) {
        CanBeSold sellable;
        Goods goods;
        Vehicle vehicle1 = new Vehicle(10, 3000, 4000);
        Vehicle vehicle2 = new Vehicle(20, 6000, 5000);
        sellable = vehicle1;
        goods = vehicle2;

        System.out.println(sellable);
        System.out.println(goods);
        System.out.println(sellable.productionPrice());
        System.out.println(sellable.sellingPrice());

        System.out.println(goods.productionPrice());
        System.out.println(goods.sellingPrice());

    }

}