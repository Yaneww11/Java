package CompanyAndEmployees;


public enum ContractTypes {
    PERMANENT(0), PART_TIME(0), TRAINEE(0);
    private double salaryPerHour;

    ContractTypes(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
