import clases.DeliverableItem;
import clases.Document;
import clases.Material;
import clases.WeightedItem;

public class Main {
    public static void main(String[] args) {
        String materialName = "Glass";
        boolean isFragile = true;
        boolean toClientsAddress = true;
        double minPrice = 0;
        double weight = 0;
        double pricePerKg = -1;
        double additionalPrice = -2;

        DeliverableItem.setAdditionalPrice(additionalPrice);
        Material material1 = new Material(materialName, isFragile);
        DeliverableItem item1;
        item1 = new Document(toClientsAddress, minPrice);
        System.out.println(item1.deliveryPrice());
        item1 = new WeightedItem(toClientsAddress, material1, weight, pricePerKg);
        System.out.println(item1.deliveryPrice());

    }
}