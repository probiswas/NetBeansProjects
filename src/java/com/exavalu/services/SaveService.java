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

/**
 *
 * @author lenovo
 */
public class SaveService {
    public static SaveService saveService = null;
    
    private SaveService(){}
    
    public static SaveService getInstance()
    {
        if(saveService==null)
        {
            return new SaveService();
        }
        else
        {
            return saveService;
        }
    }
    public boolean doSave(Employee emp)
    {
        boolean result = false;
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE employees SET firstName = ? , lastName = ? , phone = ? , address = ? , gender = ? , age = ? , basicSalary = ?, carAllowance = ?, deptId = ? , roleId = ? WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setString(7, emp.getBasicSalary());
            preparedStatement.setString(8, emp.getCarAllowance());
            preparedStatement.setString(9, emp.getDepartmentId());
            preparedStatement.setString(10, emp.getRoleId());
            preparedStatement.setString(11, emp.getEmployeeId());

            System.out.println("Save Employee sql=" + preparedStatement);

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
}
