package shop;

public class Engineer implements Provider{
    private double perHour;
    private double hoursWorked;
    private CanBeSold sellable;

    public Engineer(double perHour, double hoursWorked) {
        this.perHour = perHour;
        this.hoursWorked = hoursWorked;
    }

    public double earnings() {
        return this.perHour*this.hoursWorked;
    }


    public String toString() {
        return "Engineer{" +
                "perHour=" + perHour +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}
