import ElectricDevices.Cooker;
import ElectricDevices.ElectricDevice;
import ElectricDevices.Manufacturer;
import ElectricDevices.WashingMachine;
import repo.Author;
import repo.Book;
import repo.Document;
import repo.Repo;

public class Main {
    public static void main(String[] args) {
        /*
        Figure f = new Figure(10, 10);
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);
        Figure figref;
        figref = r;
        System.out.println("Area is " + figref.area());
        figref = t;
        System.out.println("Area is " + figref.area());
        figref = f;
        System.out.println("Area is " + figref.area());


        Repo repo1 = new Repo(20);
        Repo repo2 = new Repo(30, 5, 12);
        Document doc1 = new Document(5, "txt", "Doc 1");
        Document doc2 = new Document(8, "txt", "Doc 2");
        Author author = new Author("Ivanov");
        Book book1 = new Book(10, "pdf", "Book 1", author, "!@#$%");

        //System.out.println(repo1.uploadDocument(doc1));
        //repo1.uploadDocument(doc2);
        //System.out.println(repo1.uploadDocument(book1));
        //System.out.println(repo1);

        Document docRef = doc1;
        System.out.println(docRef);
        docRef = book1;
        System.out.println(docRef);

         */

        String manufacturerName = "ElDevMan";
        boolean isLongTermWarranty = true;
        int minWarranty = 12;
        boolean isGas = true;
        boolean isDryer = true;

        Manufacturer manufacturer1 = new Manufacturer(manufacturerName, isLongTermWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer1, minWarranty);
        System.out.println(electricDevice.warranty());
        Cooker cooker1 = new Cooker(manufacturer1, minWarranty, isGas);
        System.out.println(cooker1.warranty());
        WashingMachine washingMachine1 = new WashingMachine(manufacturer1, minWarranty, isDryer);
        System.out.println(washingMachine1.warranty());

    }
}