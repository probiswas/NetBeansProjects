<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title>Employee Management</title>      
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/signin.css" rel="stylesheet">  
        <!-- Custom styles for this template -->
    </head>
    <body class="text-center">

        <main class="form-signin w-100 m-auto">
            <c:set var = "emp" value='${Emp}'/>
            <form action="SaveEmployee" method="Post">
                
                <img class="mb-4" src="https://s3-us-west-2.amazonaws.com/cbi-image-service-prd/modified/d6b0e553-40e5-4fcc-aae9-46e950dcb071.png" alt="" width="300" height="100">
                <h1 class="h3 mb-3 fw-normal">Edit employee data</h1>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="employeeId" value=${emp.getEmployeeId() } readonly>
                    <label for="floatingInput">Employee Id</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="firstName" value=${emp.getFirstName() }>
                    <label for="floatingInput">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" value=${emp.getLastName() }>
                    <label for="floatingInput">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address" value=${emp.getAddress() }>
                    <label for="floatingInput">Address</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="phone" name="phone" value=${emp.getPhone()}>
                    <label for="floatingInput">Phone</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="gender" name="gender" value=${emp.getGender()}>
                    <label for="floatingInput">Gender</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="age" name="age" value=${emp.getAge()}>
                    <label for="floatingInput">Age</label>
                </div>
                 <div class="form-floating">
                  
                    <c:set var = "deptList" value='${DeptList}'/>
                        <select name="departmentId" class="form-select" id="departmentId">
                        <option value=${emp.getDepartmentId()} hidden>${emp.getDeptName()}</option>
                        
                        <c:forEach items="${DeptList}" var="dept">
                        <option value=${dept.getDepartmentId()}> ${dept.getDepartmentName()}  </option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Department</label>
                </div>
                </div>
                 <div class="form-floating">
                    <c:set var = "roleList" value='${requestScope["RoleList"]}'/>
                    <select name="roleId" class="form-select" id="roleId">
                        <option value=${emp.getRoleId()} hidden>${emp.getRoleName()}</option>
                        <c:forEach items="${RoleList}" var="role">
                        <option value=${role.getRoleId()}> ${role.getRoleName()}</option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Role</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary" value=${emp.getBasicSalary()}>
                    <label for="floatingInput">Basic Salary</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="carAllaowance" name="carAllowance" value=${emp.getCarAllowance()}>
                    <label for="floatingInput">Car Allowance</label>
                </div>
                
                <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>
                
            </form>
        </main>
    </body>
</html>
