import CompanyAndEmployees.Company;
import CompanyAndEmployees.ContractTypes;
import CompanyAndEmployees.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String companyName = "TechComp";
        int maxNumberOfEmployees = 5;
        double increasePercentage = 5;
        String contractType = "TRAINEE";
        List<Double> minSalaryList = new ArrayList<Double>();
        minSalaryList.add(20.0);
        minSalaryList.add(15.0);
        minSalaryList.add(10.0);

        List<String> namesList = new ArrayList<String>();
        namesList.add("Maria");
        namesList.add("Anna");
        namesList.add("Pavel");
        namesList.add("Monika");
        namesList.add("Toni");
        namesList.add("Moni");

        List<Integer> workedHoursList = new ArrayList<Integer>();
        workedHoursList.add(60);
        workedHoursList.add(100);
        workedHoursList.add(150);
        workedHoursList.add(80);
        workedHoursList.add(150);
        workedHoursList.add(80);

        List<String> contractTypeList = new ArrayList<String>();
        contractTypeList.add("PERMANENT");
        contractTypeList.add("PERMANENT");
        contractTypeList.add("PART_TIME");
        contractTypeList.add("PERMANENT");
        contractTypeList.add("PERMANENT");
        contractTypeList.add("PART_TIME");

        List<Double> additionalSalaryList = new ArrayList<Double>();
        additionalSalaryList.add(20.0);
        additionalSalaryList.add(40.0);
        additionalSalaryList.add(20.0);
        additionalSalaryList.add(20.0);
        additionalSalaryList.add(20.0);
        additionalSalaryList.add(40.0);

        ContractTypes.PERMANENT.setSalaryPerHour(minSalaryList.get(0));
        ContractTypes.PART_TIME.setSalaryPerHour(minSalaryList.get(1));
        ContractTypes.TRAINEE.setSalaryPerHour(minSalaryList.get(2));

        Company company1 = new Company(companyName, maxNumberOfEmployees);
        Employee employee1 = new Employee(namesList.get(0), workedHoursList.get(0), BigDecimal.valueOf(additionalSalaryList.get(0)), ContractTypes.valueOf(contractTypeList.get(0)));
        Employee employee2 = new Employee(namesList.get(1), workedHoursList.get(1), BigDecimal.valueOf(additionalSalaryList.get(1)), ContractTypes.valueOf(contractTypeList.get(1)));
        Employee employee3 = new Employee(namesList.get(2), workedHoursList.get(2), BigDecimal.valueOf(additionalSalaryList.get(2)), ContractTypes.valueOf(contractTypeList.get(2)));
        Employee employee4 = new Employee(namesList.get(3), workedHoursList.get(3), BigDecimal.valueOf(additionalSalaryList.get(3)), ContractTypes.valueOf(contractTypeList.get(3)));
        Employee employee5 = new Employee(namesList.get(4), workedHoursList.get(4), BigDecimal.valueOf(additionalSalaryList.get(4)), ContractTypes.valueOf(contractTypeList.get(4)));
        Employee employee6 = new Employee(namesList.get(5), workedHoursList.get(5), BigDecimal.valueOf(additionalSalaryList.get(5)), ContractTypes.valueOf(contractTypeList.get(5)));


        company1.hireEmployee(employee1);
        company1.hireEmployee(employee2);
        company1.hireEmployee(employee3);
        company1.hireEmployee(employee4);
        company1.hireEmployee(employee5);
        company1.hireEmployee(employee6);
        System.out.println(company1.averageSalary());
        company1.increaseSalaries(BigDecimal.valueOf(0));
        System.out.println(company1.averageSalary());
        System.out.println(company1.averageSalaryPerContractType(ContractTypes.valueOf(contractType)));


    }
}