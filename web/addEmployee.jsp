<%-- 
    Document   : addEmployee
    Created on : 27-Jan-2023, 9:53:58 am
    Author     : lenovo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
        <link href="css/signin.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="text-center">

        <main class="form-signin w-100 m-auto">

            <form action="AddEmployee" method="post">

                <img class="mb-4" src="https://s3-us-west-2.amazonaws.com/cbi-image-service-prd/modified/d6b0e553-40e5-4fcc-aae9-46e950dcb071.png" alt="" width="300" height="100">
                <h1 class="h3 mb-3 fw-normal">Add employee data</h1>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="firstName" required>
                    <label for="floatingInput">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" required>
                    <label for="floatingInput">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address" required>
                    <label for="floatingInput">Address</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="phone" name="phone" oninvalid="this.setCustomValidity('Enter valid 10 digit number')" pattern="[6-9]{1}[0-9]{9}" required >
                    <label for="floatingInput">Phone</label>
                </div>
                <div class="form-floating">
                    <select name="gender" class="form-select" id="gender" required>
                        <option value="">Select Gender</option>
                        <option value="Male">Male</option>  
                        <option value="Female">Female</option> 
                        <option value="Other">Other</option> 
                    </select>
                    <label for="floatingInput">Gender</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="age" name="age" required>
                    <label for="floatingInput">Age</label>
                </div>
                <div class="form-floating">
                    <select name="departmentId" class="form-select" id="departmentId" required>
                        <option value="">Select Department</option>

                        <c:forEach items="${DeptList}" var="dept">
                            <option value=${dept.getDepartmentId()}> ${dept.getDepartmentName()}  </option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Department</label>
                </div>

                </div>
                <div class="form-floating">
                    <select name="roleId" class="form-select" id="roleId" required>
                        <option value="">Select Role</option>
                        <c:forEach items="${RoleList}" var="role">
                            <option value=${role.getRoleId()}> ${role.getRoleName()}  </option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Role</label>
                </div>
                <div class="form-floating">
                    <input type="number" step=0.001 class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary" required>
                    <label for="floatingInput">Basic Salary</label>
                </div>
                <div class="form-floating">
                    <input type="number" value=0.0 step=0.001 class="form-control" id="floatingInput" placeholder="carAllowance" name="carAllowance">
                    <label for="floatingInput">Car Allowance</label>
                </div>

                <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>

            </form>
        </main>

    </body>

</html>
