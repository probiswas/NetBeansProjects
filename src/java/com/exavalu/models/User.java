/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.exavalu.models;

import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.LoginService;
import com.exavalu.services.RoleService;
import com.exavalu.services.SignupService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

 

/**
*
* @author Avijit
*/
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable
{
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }
    
    private String emailAddress,password,firstName,lastName;    

     public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = LoginService.getInstance().doLogin(this);

        if (success) {
            
            System.out.println("returning Success from doLogin method");
            result = "SUCCESS";
            
            
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
        sessionMap.put("EmpList", empList);
        
        ArrayList deptList = new ArrayList();
        deptList = DepartmentService.getAllDepartment();
        sessionMap.put("DeptList", deptList);
        
        ArrayList roleList = new ArrayList();
        roleList = RoleService.getAllRoles();
        sessionMap.put("RoleList", roleList);
        sessionMap.put("Loggedin", "NotNull");
            
        } else {
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }
     
    public String doSignup() throws Exception {        
        boolean result=SignupService.getInstance().doSignup(this);
        
        if(result)
            return "SUCCESS";
        else
            return "FAILURE";
    }
    
    public String doLogout(){
        sessionMap.invalidate(); 
        return "SUCCESS";
    }
    
    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

 

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

 

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

 

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

 

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

 

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

 

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

 

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
}