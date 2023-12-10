package ra.presentation;

import ra.businessImp.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeManagement {
    Employee[] employee = new Employee[100];
    int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee1 = new Employee();
        EmployeeManagement emp = new EmployeeManagement();
        do {
            System.out.println("*************Menu****************");
            System.out.println("1.Nhập thông tin n sản phẩm: ");
            System.out.println("2 . Hiển thị thông tin nhân viên");
            System.out.println("3. Tính lương các nhân viên");
            System.out.println("4. Tìm kiếm nhân viên theo tên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa nhân viên theo mã nhân viên");
            System.out.println("7.  Sắp xếp nhân viên theo lương tăng dần (Comparable)");
            System.out.println("8. . Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)");
            System.out.println("9. . Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)");
            System.out.println("10. Thoát");
            System.out.println("Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    emp.inputInfor(scanner);
                    System.out.println("Đã hoa thành");
                    break;
                case 2:
                    emp.outInfor();
                    System.out.println("Đã hoàn thành");
                    break;
                case 3:
                    System.out.println("Cập nhật tiền lương của nhân viên");
                    emp.sauTinhLuong();
                    System.out.println("Đã hoàn thành");
                    break;
                case 4:
                    emp.findEmployee(scanner, emp.employee, emp.index);
                    System.out.println("Đã hoàn thành");
                    break;
                case 5:
                    emp.findUpdate(scanner, emp.employee, emp.index);
                    System.out.println("Đã hoàn thành");
                    break;
                case 6:
                    System.out.println("Hoàn thành");
                    break;
                case 7:
                    emp.sapXepTangDanLuong();
                    System.out.println("Đã hoàn thành");
                    break;
                case 8:
                    employee1.sapXepTenGiamDan(emp.employee);
                    employee1.toString();
                    System.out.println("Đã Hoàn Thành");
                    break;
                case 9:
                    employee1.sapXepNamSinhTangDan(emp.employee);
                    employee1.toString();
                    System.out.println("Đã hoàn thành");
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn tự 1-10");
            }
        } while (true);
    }

    public void inputInfor(Scanner scanner) {
        System.out.println("Nhập vào số phần tử  mảng: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            if (index < employee.length) {
                employee[index] = new Employee();
                employee[index].inputData(scanner, index, employee);
                index++;
            }
        }
    }

    public void outInfor() {
        for (int i = 0; i < index; i++) {
            employee[i].displayData();
        }
    }

    public void sauTinhLuong() {
        for (int i = 0; i < index; i++) {
            employee[i].calSalary();
        }
    }

    public void findEmployee(Scanner scanner, Employee[] employee, int index) {
        System.out.println("Nhập vào tên nhân viên cần tìm: ");
        String employeeName = scanner.nextLine();
        boolean checkCout = false;
        for (int i = 0; i < index; i++) {
            if (employee[i].getName().equals(employeeName)) {
                System.out.println("Đã có nhân viên này");
                checkCout = true;
                break;
            }
        }
        if (!checkCout) {
            System.out.println("Không có nhân viên này");
        }
    }

    public void findUpdate(Scanner scanner, Employee[] employee, int index) {
        System.out.println("ID cần cập nhật: ");
        String findID = scanner.nextLine();
        boolean checkCout = false;// chưa xuất hiện
        for (int i = 0; i < index; i++) {
            if (employee[i].getId().equals(findID)) {
                boolean check = true;
                do {
                    System.out.println("----------Menu---------------");
                    System.out.println("1. Cập nhật lại tên:");
                    System.out.println("2. Cập nhật lại năm sinh");
                    System.out.println("3. Cập nhật lại hệ số lương nhân viên");
                    System.out.println("4. Cập nhật lại tiền hoa hồng hàng tháng");
                    System.out.println("5. Cập nhật lại trạng thái");
                    System.out.println("6. Thoát");
                    System.out.println("Bạn cần cập nhật lại nội dung nào? ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập vào tên mới: ");
                            String newName = scanner.nextLine();
                            employee[i].setName(newName);
                            System.out.println("Đã thay đổi tên thành công");
                            break;
                        case 2:
                            System.out.println("Nhập vào năm sinh mới");
                            String newyear = scanner.nextLine();
                            employee[i].setYear(newyear);
                            System.out.println("Đã thay đổi tên thành công");
                            break;
                        case 3:
                            System.out.println("Cập nhật hệ số lương mới: ");
                            float newRate = Float.parseFloat(scanner.nextLine());
                            employee[i].setRate(newRate);
                            System.out.println("Thay đổi thành công");
                            break;
                        case 4:
                            System.out.println("Cập nhật lại tiền hoa hồng: ");
                            float newConmmission = Float.parseFloat(scanner.nextLine());
                            employee[i].setConmmission(newConmmission);
                            System.out.println("Thanh đổi thành công");
                            break;
                        case 5:
                            System.out.println("Cập nhật thành công");
                            break;
                        case 6:
                            check = false;
                        default:
                            System.out.println("Lựa chọn từ 1 - 5");
                    }
                } while (check);
            }
        }
        if (!checkCout) {
            System.out.println("Không có ID này");
        }
    }

    public void sapXepTangDanLuong() {
        Arrays.sort(employee, 0, index);
        for (int i = 0; i < index; i++) {
            System.out.println(employee[i].toString());
        }
    }

}


