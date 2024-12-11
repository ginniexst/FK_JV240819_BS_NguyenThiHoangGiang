package entity;

import business.DepartmentBusiness;

import java.util.Scanner;

public class Department implements IManagement {
    private int departmentId;
    private String departmentName;
    private boolean departmentStatus;

    public Department() {
    }

    public Department(int departmentId, String departmentName, boolean departmentStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentStatus = departmentStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean isDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.departmentName = inputDepartmentName(scanner);
    }

    public String inputDepartmentName(Scanner scanner) {
        System.out.println("Nhập vào tên phòng ban:");
        do {
            String departmentName = scanner.nextLine();
            if (departmentName != null && departmentName.trim().length() != 0) {
                Department departmentCheck = DepartmentBusiness.findDepartmentByName(departmentName);
                if (departmentCheck != null) {
                    System.err.println("Tên phòng ban đã tồn tại. Vui lòng nhập lại");
                } else {
                    return departmentName;
                }
            } else {
                System.err.println("Vui lòng nhập lại tên phòng ban");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("%d. %s - Trạng thái: %s\n",
                this.departmentId, this.departmentName, this.departmentStatus ? "Hoạt động" : "Ngừng hoạt động");
    }
}
