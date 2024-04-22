package Boxpackage;

public class Box {

    private double width;
    private double height;
    private double depth;

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double volume() {
        return this.width * this.height * this.depth;
    }

    public void increaseDimensions(double increasePercentage) throws IllegalArgumentException {
        if ((increasePercentage < 0) || (increasePercentage > 100)) {
            throw new IllegalArgumentException("The value of "
                    + "the argument must be between 0 and 100"
                    + " inclusive! The argument is: "
                    + increasePercentage);
        } else {
            this.width += this.width * increasePercentage / 100;
            this.height += this.height * increasePercentage / 100;
            this.depth += this.depth * increasePercentage / 100;
        }
    }

    public void optionalIncreaseDimensions(double increasePercentage, double volumeNumber) {
        if (this.volume() <= volumeNumber) {
            try {
                increaseDimensions(increasePercentage);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "box.Box{" + "width=" + width + ", height=" + height + ", depth=" + depth + '}';
    }
}
