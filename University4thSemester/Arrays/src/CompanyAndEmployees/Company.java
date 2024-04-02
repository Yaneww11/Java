package CompanyAndEmployees;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private int maxEmployees;
    private List<Employee> listOfEmployees;

    public Company(String name, int maxEmployees) {
        this.name = name;
        this.maxEmployees = maxEmployees;
        this.listOfEmployees = new ArrayList<Employee>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public void setListOfEmployees(List<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    public boolean isEmployeeInCompany(int id){
        for (Employee employee: listOfEmployees){
            if (employee.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean isHaveSpaceToAddEmployee(){
        return this.listOfEmployees.size() < this.maxEmployees;
    }

    public boolean hireEmployee(Employee employee){
        if (!isEmployeeInCompany(employee.getId()) && isHaveSpaceToAddEmployee()){
            this.listOfEmployees.add(employee);
            return true;
        }
        return false;
    }

    public boolean fireEmployee(Employee employee){
        if (isEmployeeInCompany(employee.getId())){
            this.listOfEmployees.remove(employee);
            return true;
        }
        return false;
    }

    public BigDecimal averageSalary(){
        if (maxEmployees > 0 && !this.listOfEmployees.isEmpty()){
            BigDecimal result = BigDecimal.valueOf(0);
            for (Employee employee: this.listOfEmployees){
                result = result.add(employee.salary());
            }
            return result.divide(BigDecimal.valueOf(this.listOfEmployees.size()), 2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }

    public void increaseSalaries(BigDecimal percent){
        if (percent.compareTo(BigDecimal.ZERO) > 0){
            for (Employee employee: this.listOfEmployees){
                employee.increaseSalary(percent);
            }
        }
    }


    public BigDecimal averageSalaryPerContractType(ContractTypes contractType){
        if (maxEmployees > 0 && !this.listOfEmployees.isEmpty()){
            int counter = 0;
            BigDecimal result = BigDecimal.valueOf(0);
            for (Employee employee: this.listOfEmployees){
                if (employee.getContractType().name().equals(contractType.name())){
                    result = result.add(employee.salary());
                    counter++;
                }
            }
            if (counter == 0){
                return BigDecimal.ZERO;
            }
            return result.divide(BigDecimal.valueOf(counter), 2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", maxEmployees=" + maxEmployees +
                ", listOfEmployees=" + listOfEmployees +
                '}';
    }
}
