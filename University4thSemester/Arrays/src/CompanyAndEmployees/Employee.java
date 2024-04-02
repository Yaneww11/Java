package CompanyAndEmployees;

import java.math.BigDecimal;
import java.math.RoundingMode;



public class Employee {
    private String name;
    private static int counter = 0;
    private int id;
    private int workedHours;
    private ContractTypes contractType;
    private BigDecimal additionalSalary;

    public Employee(String name, int workedHours,BigDecimal additionalSalary, ContractTypes contractType) {
        this.name = name;
        this.id = counter;
        this.workedHours = workedHours;
        this.additionalSalary = additionalSalary;
        this.contractType = contractType;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    public ContractTypes getContractType() {
        return contractType;
    }

    public void setContractType(ContractTypes contractType) {
        this.contractType = contractType;
    }

    public BigDecimal salary(){
        BigDecimal result = this.additionalSalary.add(BigDecimal.valueOf(this.contractType.getSalaryPerHour()));
        result = result.multiply(BigDecimal.valueOf(this.workedHours));
        return result;
    }
    public void increaseSalary(BigDecimal percent){
        if (percent.compareTo(BigDecimal.ZERO) > 0){
            BigDecimal addedMoney = this.additionalSalary.multiply(percent)
                    .divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_UP);
            this.additionalSalary = this.additionalSalary.add(addedMoney);
        }
    }

    public BigDecimal getAdditionalSalary() {
        return additionalSalary;
    }

    public void setAdditionalSalary(BigDecimal additionalSalary) {
        this.additionalSalary = additionalSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", workedHours=" + workedHours +
                ", contractType=" + contractType +
                ", additionalSalary=" + additionalSalary +
                '}';
    }
}
