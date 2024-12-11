package presentation;

import business.DepartmentBusiness;
import entity.Department;

import java.util.List;
import java.util.Scanner;

public class Management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******************HR-MANAGEMENT******************");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayMenuDepartment(scanner);
                    break;
                case 2:
                    displayMenuEmployee(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-3");
            }
        } while (true);
    }

    public static void displayMenuDepartment(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("**********************DEPARTMENT-MENU********************");
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Cập nhật thông tin phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Hiển thị phòng ban có nhiều nhân viên nhất");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayDepartment();
                    break;
                case 2:
                    createDepartment(scanner);
                    break;
                case 3:
                    updateDepartment(scanner);
                    break;
                case 4:
                    deleteDepartment(scanner);
                    break;
                case 5:
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (isExit);
    }

    public static void displayDepartment() {
        List<Department> listDepartment = DepartmentBusiness.findAll();
        listDepartment.forEach(Department::displayData);
    }

    public static void createDepartment(Scanner scanner) {
        Department department = new Department();
        department.inputData(scanner);
        boolean result = DepartmentBusiness.createDepartment(department);
        if (result) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public static void updateDepartment(Scanner scanner) {
        System.out.println("Nhập vào mã phòng ban:");
        int departmentId = Integer.parseInt(scanner.nextLine());
        Department departmentUpdate = DepartmentBusiness.findDepartmentById(departmentId);
        if (departmentUpdate != null) {
            System.out.println("Cập nhật tên phòng ban:");
            String nameUpdate = scanner.nextLine();
            departmentUpdate.setDepartmentName(nameUpdate);
            boolean result = DepartmentBusiness.updateDepartment(departmentUpdate);
            if (result) {
                System.out.println("Cập nhật thành công");
            } else {
                System.err.println("Cập nhật thất bại");
            }
        } else {
            System.err.println("Mã phòng ban không tồn tại");
        }
    }

    public static void deleteDepartment(Scanner scanner) {
        System.out.println("Nhập mã phòng ban cần xóa:");
        int departmentId = Integer.parseInt(scanner.nextLine());
        Department departmentDelete = DepartmentBusiness.findDepartmentById(departmentId);
        if (departmentDelete != null) {
            boolean result = DepartmentBusiness.deleteDepartment(departmentId);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.err.println("Xóa thất bại");
            }
        } else {
            System.err.println("Mã phòng ban không tồn tại");
        }
    }

    public static void displayMenuEmployee(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("************************EMPLOYEE-MENU********************");
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Cập nhật thông tin nhân viên");
            System.out.println("4. Xóa nhân viên ");
            System.out.println("5. Hiển thị danh sách nhân viên theo phòng ban");
            System.out.println("6. Tìm kiếm nhân viên theo tên");
            System.out.println("7. Hiển thị top 5 nhân viên có lương cao nhất");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-8");
            }
        } while (isExit);
    }
}
