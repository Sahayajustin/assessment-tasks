<%@page import="com.assessment.taskmanagement.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Page</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
	font-size: 15px;
}
th{
padding: 10px 20px;
}
body {
	height: 100vh;
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: start;
	flex-direction: column;
	gap: 40px;
}

form {
	padding-top: 100px;
	display: flex;
	gap: 10px;
}

table {
	width: 60%;
	text-align: center;
}

button {
	padding: 10px 20px;
}
</style>
<body>
	<%
	Employee emp = (Employee) request.getAttribute("employee");
	%>
	<form action=<%=(emp != null) ? "save" : "employee/add"%> method="post">
		<div>
			<input type="hidden" name="employeeId"
				value="<%=(emp != null) ? emp.getEmployeeId() : 0%>" required="required">
		</div>
		<div>
			<label>Enter the Name</label> <input type=text name="employeeName"
				placeholder="Enter the Employee Name"
				value="<%=(emp != null) ? emp.getEmployeeName() : ""%>"
				required="required">
		</div>
		<div>
			<label>Enter the Email</label> <input type=email name="email"
				placeholder="Enter the Employee Email"
				value="<%=(emp != null) ? emp.getEmail() : ""%>" required="required">
		</div>

		<div>
			<label>Enter the Department</label> <input type=text
				name="department" value="<%=(emp != null) ? emp.getDepartment() : ""%>"
				placeholder="Enter the Employee Department" required="required">
		</div>
		<div>
			<label>Enter the Designation</label> <input type=text
				name="designation" value="<%=(emp != null) ? emp.getDesignation() : ""%>"
				placeholder="Enter the Employee Designation" required="required">
		</div>
		<button type="submit"><%=(emp != null) ? "update Employee" : "Add Employee"%></button>
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Email</th>
				<th>Department</th>
				<th>Designation</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Employee> employees = (List<Employee>) request.getAttribute("employees");
			int count = 1;

			if (employees != null) {
				for (Employee employee : employees) {
			%>

			<tr>
				<td><%=count++%>
				<td><%=employee.getEmployeeId()%></td>
				<td><%=employee.getEmployeeName()%></td>
				<td><%=employee.getEmail()%></td>
				<td><%=employee.getDepartment()%></td>
				<td><%=employee.getDesignation()%></td>
				<td><a href="employee/edit/<%=employee.getEmployeeId()%>"><button>Edit</button></a></td>
				<td><a href="employee/delete/<%=employee.getEmployeeId()%>"
					onclick="return confirm('are you sure to delete')"><button>Delete</button></a></td>
			</tr>
			<%
			}
			} else {
			%>
			<%=employees%>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>