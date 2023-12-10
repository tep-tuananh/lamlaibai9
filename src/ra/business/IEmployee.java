package ra.business;

import ra.businessImp.Employee;

import java.util.Scanner;

public interface IEmployee extends Comparable<Employee> {
    public static final int BASIC_SALARY = 1300000;

    public void inputData(Scanner scanner, int index, Employee[] employee);

    public void displayData();
}
