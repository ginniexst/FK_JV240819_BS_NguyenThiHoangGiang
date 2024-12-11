package business;

import entity.Department;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentBusiness {
    public static List<Department> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> listDepartments = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_department()}");
            ResultSet rs = callSt.executeQuery();
            listDepartments = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDepartmentStatus(rs.getBoolean("department_status"));
                listDepartments.add(department);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listDepartments;
    }

    public static boolean createDepartment(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt =conn.prepareCall("{call create_department(?)}");
            callSt.setString(1, department.getDepartmentName());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    public static boolean updateDepartment(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_department(?,?)}");
            callSt.setInt(1, department.getDepartmentId());
            callSt.setString(2, department.getDepartmentName());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
    public static Department findDepartmentByName(String departmentName) {
        Connection conn = null;
        CallableStatement callSt = null;
        Department department = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_department_by_name(?)}");
            callSt.setString(1, departmentName);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDepartmentStatus(rs.getBoolean("department_status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return department;
    }

    public static Department findDepartmentById(int departmentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Department department = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_department_by_id(?)}");
            callSt.setInt(1, departmentId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDepartmentStatus(rs.getBoolean("department_status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return department;
    }

    public static boolean deleteDepartment(int departmentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_department(?)}");
            callSt.setInt(1, departmentId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
}


