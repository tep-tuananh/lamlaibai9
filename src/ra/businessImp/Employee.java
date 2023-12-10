package ra.businessImp;

import ra.business.IEmployee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Employee implements IEmployee {
    private String id;//  mã nhân viên
    private String name;// tên nhân viên
    private String year; // năm sinh nhân viên
    private float rate;// hệ số lương
    private float conmmission;// hoa hồng
    private float salary;// lương nhân viên hàng tháng
    private boolean status;// Trạng thái nhân viên

    public Employee() {
    }

    public Employee(String id, String name, String year, float rate, float conmmission, float salary, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.conmmission = conmmission;
        this.salary = salary;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getConmmission() {
        return conmmission;
    }

    public void setConmmission(float conmmission) {
        this.conmmission = conmmission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus() {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner, int index, Employee[] employee) {
        System.out.println("Nhập vào  id nhân viên:  ");
        this.id = scanner.nextLine();
        System.out.println("Nhập vào tên nhân viên: ");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào năm sinh nhân viên: ");
        this.year = scanner.nextLine();
        System.out.println("Nhập vào hệ số lương nhân viên: ");
        this.rate = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào tiền hoa hồng: ");
        this.conmmission = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào trạng thái: ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    public float calSalary() {
        this.salary = this.rate * BASIC_SALARY + this.conmmission;
        return this.salary;
    }

    @Override
    public void displayData() {
        System.out.println("----------------------------------");
        System.out.println("Id nhân viên:" + this.id);
        System.out.println("Tên nhân viên: " + this.name);
        System.out.println("Năm sinh nhân viên: " + this.year);
        System.out.println("hệ số luương nhan viên: " + this.rate);
        System.out.println("Tiền hoa hồng: " + this.conmmission);
        System.out.println("Trạng thái: " + ((this.status = true) ? "Đã làm việc" : "Đã nghỉ"));
        System.out.println("Tiền lương nhân viên theo tháng: " + this.salary);
        System.out.println("----------------------------------");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", Tên nhân viên ='" + name + '\'' +
                ", Năm sinh ='" + year + '\'' +
                ", Hệ số lương =" + rate +
                ", Hoa hồng =" + conmmission +
                ", Lương của tháng =" + salary +
                ", Trạng thái =" + status +
                '}';
    }

    @Override
    public int compareTo(Employee o) {// sắp xếp chỉ 1 tiêu chí
        // so sánh dối tượng hiện tại với đối tượng khác
        return (int) (this.rate - o.getRate());
    }

    public void sapXepTenGiamDan(Employee[] employees) {
        Arrays.asList(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sapXepNamSinhTangDan(Employee[] employees) {
        Arrays.asList(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getYear().compareTo(o1.getYear());
            }
        });
    }

}
