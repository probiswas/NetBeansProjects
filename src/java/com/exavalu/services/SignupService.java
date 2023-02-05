/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class SignupService {
    
    public static SignupService signupService = null;
    
    private SignupService(){}
    
    public static SignupService getInstance()
    {
        if(signupService==null)
        {
            return new SignupService();
        }
        else
        {
            return signupService;
        }
    }
    public boolean doSignup(User user)
    {
        String sql = "insert into users values(?,?,?,?,?)";
        boolean result = false;
        try {
            
            Connection con = JDBCConnectionManager.getConnection();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1,user.getEmailAddress());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getFirstName());
            preparedStatement.setString(4,user.getLastName());
            preparedStatement.setInt(5,1);
            if(preparedStatement.executeUpdate()!=0)
            {
                result=true;
            }
            
            System.out.println("SignupService :: "+preparedStatement);

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
