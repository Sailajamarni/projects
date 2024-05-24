<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Crud.Employee" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee CRUD</title>
     <style>
      body {
    background-image: url('obg.jpg'); /* Replace 'obg.jpg' with the path to your image */
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    margin: 0; /* Reset default body margin */
    padding: 0; /* Reset default body padding */
    height: 100vh; /* Set body height to viewport height */
}

h2 {
    text-align: center;
    color: white; /* Change text color to white */
}

form {
    background-color: rgba(255, 255, 255, 0.5); /* Semi-transparent white background */
    padding: 20px;
    border-radius: 10px;
}

table {
    margin-top: 20px;
    background-color: rgba(255, 255, 255, 0.5); /* Semi-transparent white background */
    border-collapse: collapse;
    width: 80%;
    margin-left: auto;
    margin-right: auto;
}

th, td {
    padding: 10px;
    text-align: center;
}

th {
    background-color: #007bff; /* Blue background color for table header */
    color: white; /* White text color for table header */
}

    </style>
</head>
<body>
    <h2 style="text-align:center">Employee CRUD Operations</h2>

   <center>
 <form action="CrudServlet" method="post">
        Employee ID: <input type="text" name="Empid"><br><br>
        Employee Name: <input type="text" name="Empname"><br><br>
        Job: <input type="text" name="job"><br><br>
        Department: <input type="text" name="Department"><br><br>
        Salary: <input type="text" name="Sal"><br><br>
 <button type ="submit" name="action" value="add">Add</button>
 <button type ="submit" name="action" value="delete">Delete</button>
 <button type ="submit" name="action" value="update">Update</button>

  <button type="button" id="firstbutton">First</button>
  <button type="button" id="lastbutton">Last</button>
  <button type="button" id="prevbutton">Previous</button> 
  <button id="nextButton" type="button">Next</button>
  <br><br>
 </form>
 
 

    <!-- Table to display employee records -->
    <table id="employeeTable" border="1">
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Job</th>
            <th>Department</th>
            <th>Salary</th>
        </tr>
        <% 
            List<Employee> emp1 = (List<Employee>) request.getAttribute("ed");
            if (emp1 != null) {
                for (Employee emp2 : emp1) {
        %>
        <tr id="data">
            <td><%= emp2.getEmpid() %></td>
            <td><%= emp2.getEmp_name() %></td>
            <td><%= emp2.getJob() %></td>
            <td><%= emp2.getDept()%></td>
            <td><%= emp2.getSalary() %></td>  
        </tr>
        <%
                }
            }
        %>
    </table>
</center>
<script>
var rowIndex=1;
var index = 1; 
var rows; 

document.addEventListener("DOMContentLoaded", function() {
    var table = document.getElementById("employeeTable");
    rows = table.getElementsByTagName("tr");

   
    function updateFormFields(row, rowIndex) {
        var cells = row.getElementsByTagName("td");
        document.getElementsByName("Empname")[0].value = cells[1].innerHTML;
        document.getElementsByName("Empid")[0].value = cells[0].innerHTML;
        document.getElementsByName("job")[0].value = cells[2].innerHTML;
        document.getElementsByName("Department")[0].value = cells[3].innerHTML;
        document.getElementsByName("Sal")[0].value = cells[4].innerHTML;
        index = rowIndex; 
    }

   
    for (var i = 1; i < rows.length; i++) {
        rows[i].addEventListener("click", function() {
            rowIndex = Array.prototype.indexOf.call(rows, this);
            updateFormFields(this, rowIndex); 
        });
    }

    
    function moveToNext() {
        if (rowIndex < rows.length - 1) {
        	rowIndex++;
            updateFormFields(rows[rowIndex], rowIndex);
        }
    }

    
    function moveToPrev() {
        if (rowIndex > 1) {
        	rowIndex--;
            updateFormFields(rows[rowIndex], rowIndex);
        }
    }
    function showFirst() {
        updateFormFields(rows[1], 1);
        
    }

    function showLast() {
        updateFormFields(rows[rows.length - 1], rows.length - 1); 
     
    }


   
    document.getElementById("prevbutton").addEventListener("click", function() {
        moveToPrev();
        
    });
    
    document.getElementById("firstbutton").addEventListener("click",function(){
    	showFirst();
    	
    });
    document.getElementById("lastbutton").addEventListener("click",function(){
    	showLast();
    	
    });



    document.getElementById("nextButton").addEventListener("click", function() {
        moveToNext();
        
    });
});
   
    
</script>
    
</body>
</html>