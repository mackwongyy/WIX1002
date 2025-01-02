//WONG YOONG YEE, UM AY2023/2024, WIX1002
import java.util.*;

abstract class Employee {
    protected String name, type;

    public Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract double calculateTotalSalary();
}

class PermanentEmployee extends Employee {
    private char category;

    public PermanentEmployee(String name, char category) {
        super(name, "Permanent");
        this.category = category;
    }

    @Override
    double calculateTotalSalary() {
        double baseSalary = 0;

        switch(category) {
            case 'A':
                baseSalary = 4000;
                break;
            case 'B':
                baseSalary = 3000;
                break;
            case 'C':
                baseSalary = 2000;
                break;
            default:
                System.out.println("Invalid category for Permanent Employee.");
        }

        return baseSalary;
    }
}

class ContractStaff extends Employee {
    private double fixedIncome, totalSales;

    public ContractStaff(String name, double fixedIncome, double totalSales) {
        super(name, "Contract");
        this.fixedIncome = fixedIncome;
        this.totalSales = totalSales;
    }

    @Override
    double calculateTotalSalary() {
        return (fixedIncome + 0.5 * totalSales);
    }
}

class TemporaryStaff extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public TemporaryStaff(String name, double hourlyRate, int hoursWorked) {
        super(name, "Temporary");
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateTotalSalary() {
        return (hourlyRate * hoursWorked);
    }
}

public class L14Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the permenant employee.");
        String permenantEmployeeName = input.nextLine();
        System.out.println("Enter the type of the permenant employee.");
        char permenantEmployeeType = input.next().charAt(0);
        PermanentEmployee permanentEmployee = new PermanentEmployee(permenantEmployeeName, permenantEmployeeType);
        input.nextLine();

        System.out.println("Enter the name of the contract staff.");
        String contractStaffName = input.nextLine();
        System.out.println("Enter the amount of fixed income earned by the contract staff.");
        System.out.print("RM");
        long fixedIncomeOfContractStaff = 0; 
        do {
            fixedIncomeOfContractStaff = input.nextLong();
        } while(fixedIncomeOfContractStaff < 0);
        System.out.println("Enter the amount of total sales made by the contract staff.");
        System.out.print("RM");
        long totalSalesOfContractStaff = 0;
        do {
            totalSalesOfContractStaff = input.nextLong();
        } while(totalSalesOfContractStaff < 0);
        ContractStaff contractStaff = new ContractStaff(contractStaffName, fixedIncomeOfContractStaff, totalSalesOfContractStaff);
        input.nextLine();

        System.out.println("Enter the name of the temporary staff.");
        String temporaryStaffName = input.nextLine();
        System.out.println("Enter the hourly rate of the temporary staff.");
        System.out.print("RM");
        double hourlyRateOfTemporaryStaff = 0.0;
        do {
            hourlyRateOfTemporaryStaff = input.nextDouble();
        } while(hourlyRateOfTemporaryStaff < 0.0);
        System.out.println("Enter the number of hours worked per week by the temporary staff.");
        int hoursWorkedByTemporaryStaff = 0;
        do {
            hoursWorkedByTemporaryStaff = input.nextInt();
        } while(hoursWorkedByTemporaryStaff < 0);
        TemporaryStaff temporaryStaff = new TemporaryStaff(temporaryStaffName, hourlyRateOfTemporaryStaff, hoursWorkedByTemporaryStaff);
        System.out.println();

        displayEmployeeSalary(permanentEmployee);
        displayEmployeeSalary(contractStaff);
        displayEmployeeSalary(temporaryStaff);
        input.close();
    }

    private static void displayEmployeeSalary(Employee employee) {
        System.out.println("Employee Name: " + employee.name);
        System.out.println("Employee Type: " + employee.type);
        System.out.printf("Total Salary per Month: RM%.2f\n", employee.calculateTotalSalary());
        System.out.println();
    }
}