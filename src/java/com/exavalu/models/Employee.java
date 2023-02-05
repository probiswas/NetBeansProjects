/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.LoginService;
import com.exavalu.services.RoleService;
import com.exavalu.services.SaveService;
import com.exavalu.services.SearchService;
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
 * @author Avijit Chattopadhyay
 */
public class Employee extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    
    private String employeeId;
    private String firstName ;
    private String lastName ;
    private String phone ;
    private String address ;
    private String gender ;
    private String age ;
    private String departmentId ;
    private String roleId ;
    private String basicSalary ;
    private String carAllowance;
    private String roleName;
    private String deptName;
    private int status;
    
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
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getCarAllowance() {
        return carAllowance;
    }

    public void setCarAllowance(String carAllowance) {
        this.carAllowance = carAllowance;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }
    
    public String doEdit() throws Exception {
        
        Employee emp=EmployeeService.getEmployee(this.employeeId);
        sessionMap.put("Emp", emp);
        
        ArrayList deptList = new ArrayList();
        deptList = DepartmentService.getAllDepartment();
        sessionMap.put("DeptList", deptList);
        
        ArrayList roleList = new ArrayList();
        roleList = RoleService.getAllRoles();
        sessionMap.put("RoleList", roleList);
        
        return "SUCCESS";
    }
    public String doAdd() throws Exception {
        
        boolean result = EmployeeService.getInstance().addEmployee(this);
        
        ArrayList empList = EmployeeService.getInstance().getAllEmployees();
        sessionMap.put("EmpList", empList);
        
        ArrayList deptList = new ArrayList();
        deptList = DepartmentService.getAllDepartment();
        sessionMap.put("DeptList", deptList);
        
        ArrayList roleList = new ArrayList();
        roleList = RoleService.getAllRoles();
        sessionMap.put("RoleList", roleList);
        if(result)
        return "SUCCESS";
        
        else
            return "FAILURE";
    }
    public String doDelete() throws Exception {
        
        EmployeeService.getInstance().deleteEmployee(this);
        
        ArrayList empList = EmployeeService.getInstance().getAllEmployees();
        sessionMap.put("EmpList", empList);
        
        ArrayList deptList = new ArrayList();
        deptList = DepartmentService.getAllDepartment();
        sessionMap.put("DeptList", deptList);
        
        ArrayList roleList = new ArrayList();
        roleList = RoleService.getAllRoles();
        sessionMap.put("RoleList", roleList);
        
        return "SUCCESS";
    }
    public String doSave() throws Exception {
        
        String result = "FAILURE";

        boolean success = SaveService.getInstance().doSave(this);

        if (success) {
            
            System.out.println("returning Success from doLogin method");
            result = "SUCCESS";
            
        } else {
            System.out.println("returning Failure from doSave method");
        }
        ArrayList empList = EmployeeService.getInstance().getAllEmployees();
        sessionMap.put("EmpList", empList);
        
        ArrayList deptList = new ArrayList();
        deptList = DepartmentService.getAllDepartment();
        sessionMap.put("DeptList", deptList);
        
        ArrayList roleList = new ArrayList();
        roleList = RoleService.getAllRoles();
        sessionMap.put("RoleList", roleList);
        
        return result;
    }
    
    public String doSearch() throws Exception {
        
        String result = "SUCCESS";

        ArrayList empList = SearchService.doSearch(this);
        sessionMap.put("EmpList", empList);
        
        ArrayList deptList = new ArrayList();
        deptList = DepartmentService.getAllDepartment();
        sessionMap.put("DeptList", deptList);
        
        ArrayList roleList = new ArrayList();
        roleList = RoleService.getAllRoles();
        sessionMap.put("RoleList", roleList);
        
        return result;
    }
    
}
