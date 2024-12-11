package business;

import entity.Employee;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBusiness {
    public static List<Employee> findAllEmployees() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> listEmployees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_employee}");
            ResultSet rs = callSt.executeQuery();
            listEmployees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.getPosition(rs.getString("position"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setHireDate(rs.getDate("hire_date"));
                employee.setDepartmentId(rs.getInt("department_id"));
                listEmployees.add(employee);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listEmployees;
    }

    public static Employee findEmployeeByName(String employeeName) {
        Connection conn = null;
        CallableStatement callSt = null;
        Employee employee = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_employee_by_name(?)}");
            callSt.setString(1, employeeName);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setPosition(rs.getString("position"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setHireDate(rs.getDate("hire_date"));
                employee.setDepartmentId(rs.getInt("department_id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employee;
    }
}
