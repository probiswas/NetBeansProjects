/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.Employee;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class EmployeeService {
    
    public static EmployeeService employeeService = null;
    
    public static EmployeeService getInstance()
    {
        if(employeeService==null)
        {
            return new EmployeeService();
        }
        else
        {
            return employeeService;
        }
    }
    
    public ArrayList getAllEmployees()
    {
        ArrayList empList = new ArrayList();
        String sql = "SELECT * FROM employees e join departments d join roles r on e.deptId=d.departmentId and e.roleId=r.roleId";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Employee emp = new Employee();
                
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentId(rs.getString("deptId"));
                emp.setRoleId(rs.getString("roleId"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setDeptName(rs.getString("departmentName"));
                
                empList.add(emp);
            }
            
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+empList.size());
        return empList;
    }
    
    public static Employee getEmployee(String employeeId) {

        Employee emp = new Employee();

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, departments d, roles r where e.deptId=d.departmentId and e.roleId=r.roleId and  e.employeeId=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            System.out.println("Get employee from empId = " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDeptName(rs.getString("departmentName"));
                emp.setDepartmentId(rs.getString("deptId"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setRoleId(rs.getString("roleId"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return emp;

    }

    public boolean addEmployee(Employee emp) {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "INSERT INTO employees"
                + "(firstName, "
                + "lastName, "
                + "phone, "
                + "address, "
                + "gender, "
                + "age, "
                + "deptId, "
                + "roleId, "
                + "basicSalary, "
                + "carAllowance) "
                + "VALUES "
                + "(? , "
                + "? , "
                + "? , "
                + "? , "
                + "? , "
                + "? , "
                + "? , "
                + "? , "
                + "? , "
                + "?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setString(7, emp.getDepartmentId());
            preparedStatement.setString(8, emp.getRoleId());
            preparedStatement.setDouble(9, Double.parseDouble(emp.getBasicSalary()));
            preparedStatement.setDouble(10, Double.parseDouble(emp.getCarAllowance()));

            System.out.println("add statement = " + preparedStatement);

            int row=preparedStatement.executeUpdate();
            
            if (row == 1) {
                result = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void deleteEmployee(Employee emp) {
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "delete from employees where employeeId = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getEmployeeId());

            System.out.println("Delete statement = " + preparedStatement);
            preparedStatement.executeUpdate();
      
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
