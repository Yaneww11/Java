package shop;

public class Vehicle extends Goods{
    private double materials_cost;
    private double salaries_cost;


    public Vehicle(double overcharge, double materials_cost, double salaries_cost) {
        super(overcharge);
        this.materials_cost = materials_cost;
        this.salaries_cost = salaries_cost;
    }

    public double getMaterials_cost() {
        return materials_cost;
    }

    public double getSalaries_cost() {
        return salaries_cost;
    }

    @Override
    public double productionPrice() {
        return this.materials_cost + this.salaries_cost;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "materials_cost=" + materials_cost +
                ", salaries_cost=" + salaries_cost +
                "} " + super.toString();
    }
}
