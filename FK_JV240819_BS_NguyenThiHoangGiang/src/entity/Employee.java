package entity;

import business.EmployeeBusiness;

import java.util.Date;
import java.util.Scanner;

public class Employee implements IManagement{
    private int employeeId;
    private String employeeName;
    private String position;
    private double salary;
    private Date hireDate;
    private int departmentId;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String position, double salary, Date hire_date, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hire_date;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition(String position) {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.employeeName = inputEmployeeName(scanner);
        this.position = inputPosition(scanner);
        this.salary = inputSalary(scanner);
    }

    public String inputEmployeeName(Scanner scanner){
        System.out.println("Nhập vào tên nhân viên:");
        do {
            String employeeName = scanner.nextLine();
            if (employeeName != null && employeeName.trim().length() != 0) {
                Employee employeeCheck = EmployeeBusiness.findEmployeeByName(employeeName);
                if (employeeCheck != null) {
                    System.err.println("Tên nhân viên đã tồn tại, vui lòng nhập lại");
                } else {
                    return employeeName;
                }
            } else {
                System.err.println("Vui lòng nhập lại tên nhân viên");
            }
        } while (true);
    }

    public String inputPosition(Scanner scanner){
        System.out.println("Nhập vào vị trí công việc:");
        do {
            String position = scanner.nextLine();
            if (position != null && position.trim().length() != 0) {
                return position;
            } else {
                System.err.println("Vui lòng nhập lại vị trí công việc");
            }
        } while (true);
    }

    public double inputSalary(Scanner scanner){
        System.out.println("Nhập vào mức lương:");
        do {
            double salary = Double.parseDouble(scanner.nextLine());
            if (salary > 0) {
                return salary;
            } else {
                System.err.println("Vui lòng nhập lại mức lương");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.print("Mã nhân viên: " + this.employeeId +
                "Tên nhân viên: " + this.employeeName + "Chức vụ: " + this.position + "Mức lương: " + this.salary);
        System.out.print("Ngày tuyển dung: " + this.hireDate + "Phòng ban: " + this.departmentId);
    }
}
