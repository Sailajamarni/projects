<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Job</th>
            <th>Department ID</th>
        </tr>
        <c:forEach items="${elist}" var="employee">
            <tr>
                <td>${employee.empNo}</td>
                <td>${employee.empName}</td>
                <td>${employee.job}</td>
                <td>${employee.deptNo}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
