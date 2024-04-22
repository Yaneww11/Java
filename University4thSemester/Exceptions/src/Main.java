import Boxpackage.Box;

public class Main {
    public static void main(String[] args) {

        Box box = new Box(2, 3, 4);
        System.out.println(box);
        double increasePercentage = 300;
        try {
            box.increaseDimensions(increasePercentage);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println(box);
        double volumeNumber = 100;
        box.optionalIncreaseDimensions(increasePercentage, volumeNumber);
    }
}