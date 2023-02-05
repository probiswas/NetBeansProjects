<%-- 
    Document   : landingPage
    Created on : 22-Dec-2022, 12:00:33 PM
    Author     : Avijit Chattopadhyay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->
        <link rel="stylesheet" href="css/all.min.css">
        <link rel="stylesheet" href="css/reset-min.css">
        <link rel="stylesheet" href="css/algolia-min.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/docs.min.css">
        <link rel="stylesheet" href="css/index.css">
        <title>Employee Management</title>
    </head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!<!-- I want to check my session before showing any content to the user -->

    <% if (request.getSession().getAttribute("Loggedin") == null) {%>
    <c:redirect url = "login.jsp"/>
    <%}%>



    <jsp:include page="menu.jsp"></jsp:include>

        <!-- search-->
        <form class="form-inline"action="SearchEmployee" method="post">
            <div class="container" >
                <div class="row">
                    <div class="form-control col-sm">
                        <input class="form-control" type="text" placeholder="First Name" name="firstName">
                    </div>
                    <div class="form-control col-sm">
                        <input class="form-control" type="text" placeholder="Last Name" name="lastName">
                    </div>
                    <div class="form-control col-sm">
                        <input class="form-control" type="text" placeholder="Gender" name="gender">
                    </div>
                    <input class="form-control" type="hidden" name="max" value=${max}>

                <!--                    show departments-->


                <div class="form-control col-sm">

                    <select name="deptName" class="form-select" id="departmentName">
                        <option value="" hidden>Department</option>
                        <c:forEach items="${DeptList}" var="dept">
                            <option value=${dept.getDepartmentName()}> ${dept.getDepartmentName()} </option>
                        </c:forEach>  

                    </select>
                </div>





                <div class="form-control col-sm">

                    <select name="roleName" class="form-select" id="roleName">
                        <option value="" hidden>Role</option>

                        <c:forEach items="${RoleList}" var="role">
                            <option value=${role.getRoleName()}> ${role.getRoleName()}  </option>
                        </c:forEach>
                    </select>
                </div>


                <div class="form-control col-sm">
                    <button type="submit" class="form-control btn btn-primary mb-2">Search</button>
                </div>

            </div>
        </div>
    </form>            
    <!--search end-->

    <div id="example">
        <script>
            init({
                title: 'Large data',
                desc: 'Use `virtualScroll` to enable the virtual scroll to play with large data sets (10000 rows).',
                links: ['bootstrap-table.min.css'],
                scripts: ['bootstrap-table.min.js']
            })
        </script>



        <div class="bootstrap-table bootstrap5">
            <div class="fixed-table-toolbar"><div class="bs-bars float-left">

                </div><div class="columns columns-right btn-group float-right"><div class="keep-open btn-group" title="Columns">
                        <div class="dropdown-menu dropdown-menu-right" style=""><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="id" value="0" checked="checked"> <span>ID</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="name" value="1" checked="checked"> <span>Item Name</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="price" value="2" checked="checked"> <span>Item Price</span></label></div></div></div></div>

            <div class="table-responsive" style="height: 542px; padding-bottom: 50.5px;">

                <div>
                    <table id="table" data-height="400" data-virtual-scroll="false" class="table table-bordered table-hover" style="margin-top: -9.5px;">
                        <thead>
                            <c:choose>
                                <c:when test = "${requestScope.noData != null}">
                                    <tr>
                                        <td colspan="5">
                                            <h2 style="border:2px solid rgb(255, 99, 71); background-color:rgba(255, 99, 71, 0.5); font-size:15px;">
                                                <c:out value="${requestScope.noData}"> </c:out>
                                                </h2>
                                            </td>
                                        </tr>
                                </c:when>
                            </c:choose>
                            <tr>
                                <th>
                                    Employee Id
                                </th>
                                <th>
                                    First Name
                                </th>
                                <th>
                                    Last Name
                                </th>
                                <th>
                                    Address
                                </th>
                                <th>
                                    Phone
                                </th>
                                <th>
                                    Gender
                                </th>
                                <th>
                                    Age
                                </th>

                                <th>
                                    Department Name  
                                </th>

                                <th>
                                    Role Name  
                                </th>
                                <th>
                                    Basic Salary
                                </th>
                                <th>
                                    Car Allowance
                                </th>
                                <th>
                                    Action
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var='employees' value='${EmployeeService.getInstance().getAllEmployees()}'/>
                            <c:forEach items='${EmpList}' var="emp">
                                <tr data-index="0">
                                    <td>
                                        ${emp.getEmployeeId()}
                                    </td>
                                    <td>
                                        ${emp.getFirstName()}
                                    </td>
                                    <td>
                                        ${emp.getLastName()}
                                    </td>
                                    <td>
                                        ${emp.getAddress()}
                                    </td>
                                    <td>
                                        ${emp.getPhone()}
                                    </td>
                                    <td>
                                        ${emp.getGender()}
                                    </td>
                                    <td>
                                        ${emp.getAge()}
                                    </td>

                                    <td>
                                        ${emp.getDeptName()}
                                    </td>

                                    <td>
                                        ${emp.getRoleName()}
                                    </td>
                                    <td>
                                        ${emp.getBasicSalary()}
                                    </td>
                                    <td>
                                        ${emp.getCarAllowance()}
                                    </td>

                                    <td>
                                        <a style="text-decoration: none;" href='EditEmployee?employeeId=<c:out value="${emp.employeeId}"> </c:out>'>
                                                <button class="btn btn-warning">Edit</button>
                                        </a>
                                        <a style="text-decoration: none;" href='DeleteEmployee?employeeId=<c:out value="${emp.employeeId}"> </c:out>'>
                                            <button class="btn btn-danger">Delete</button>
                                        </a>

                                        </td>
                                    </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <div class="fixed-table-footer" style="display: none;"></div>
                </div>
                <div class="fixed-table-pagination" style="display: none;"></div>
            </div>
            <div class="clearfix"></div>

            <script>
                var $table = $('#table')
                var total = 0

                function getData(number, isAppend) {
                    if (!isAppend) {
                        total = 0
                    }
                    var data = []
                    for (var i = total; i < total + number; i++) {
                        data.push({
                            'id': i,
                            'name': 'Item ' + i,
                            'price': '$' + i
                        })
                    }
                    if (isAppend) {
                        total += number
                    } else {
                        total = number
                    }
                    $('#total').text(total)
                    return data
                }

                function mounted() {
                    $table.bootstrapTable({data: getData(20)})

                    $('#load').click(function () {
                        $table.bootstrapTable('load', getData(10000))
                    })

                    $('#append').click(function () {
                        $table.bootstrapTable('append', getData(10000, true))
                    })
                }
            </script>
        </div>

</html>
