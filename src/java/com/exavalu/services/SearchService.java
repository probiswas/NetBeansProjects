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
 * @author lenovo
 */
public class SearchService {
    public static ArrayList doSearch(Employee emp)
    {
        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, departments d, roles r where e.deptId=d.departmentId and e.roleId=r.roleId "
                    + "having firstName like ?"
                    + "and lastName like ?"
                    + "and gender like ?"
                    + "and departmentName like ?"
                    + "and roleName like ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,emp.getFirstName()+"%");
            preparedStatement.setString(2,emp.getLastName()+"%");
            preparedStatement.setString(3,emp.getGender()+"%");
            preparedStatement.setString(4,emp.getDeptName()+"%");
            preparedStatement.setString(5,emp.getRoleName()+"%");
            System.out.println("Prepared statement = "+preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setAddress(rs.getString("address"));
                employee.setEmployeeId(rs.getString("employeeId"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPhone(rs.getString("phone"));
                employee.setGender(rs.getString("gender"));
                employee.setAge(rs.getString("age"));
                employee.setDeptName(rs.getString("departmentName"));
                employee.setDepartmentId(rs.getString("deptId"));
                employee.setRoleName(rs.getString("roleName"));
                employee.setRoleId(rs.getString("roleId"));
                employee.setBasicSalary(rs.getString("basicSalary"));
                employee.setCarAllowance(rs.getString("carAllowance"));

                empList.add(employee);

            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
}
