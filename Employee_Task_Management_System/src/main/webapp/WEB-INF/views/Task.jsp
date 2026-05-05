
<%@page import="com.assessment.taskmanagement.model.Employee"%>
<%@page import="com.assessment.taskmanagement.model.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Page</title>
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
    <% Task task=(Task)request.getAttribute("task");
       List<Employee> employees=(List<Employee>)request.getAttribute("employees");
    %>
	<form action=<%=(task!=null)?"save":"task/add"%> method="post">
	   <div>
			<input type="hidden" name="taskId"
				 value="<%=(task!=null)?task.getTaskId():0 %>" required="required">
		</div>
		<div>
			<label>Enter the Task Name</label> <input type=text name="taskTitle"
				placeholder="Enter the Task Name" value="<%=(task!=null)?task.getTaskTitle():"" %>" required="required">
		</div>
		<div>
		    <label>Enter the Description</label>
			<input type=text name="description" placeholder="Enter the Task Description" value="<%=(task!=null)?task.getDescription():"" %>"
				required="required">
		</div>

		<div>
		    <label>Enter the Priority</label>
			<select name="priority">
			<option value="HIGH" <%if(task!=null&&task.getPriority().equals("HIGH")){%>selected<%} %>>HIGH</option>
			<option value="MIDIUM" <%if(task!=null&&task.getPriority().equals("MIDIUM")){%>selected<%}%>>MIDIUM</option>
			<option value="LOW" <%if(task!=null&&task.getPriority().equals("LOW")){%>selected<%}%>>LOW</option>
			</select>
		</div>
		<div>
		    <label>Enter the Status</label>
			<select name="status">
			<option value="PENDING" <%if(task!=null&&task.getStatus().equals("PENDING")){%>selected<%} %>>PENDING</option>
			<option value="IN_PROGRESS" <%if(task!=null&&task.getStatus().equals("IN_PROGRESS")){%>selected<%} %>>IN_PROGRESS</option>
			<option value="COMPLETED" <%if(task!=null&&task.getStatus().equals("COMPLETED")){%>selected<%} %>>COMPLETED</option>
			</select>
		</div>
		<div>
		<label>Enter the assignedEmployee</label>
			<select name="assignedEmployeeId">
			<% if(employees!=null){
				for(Employee emp:employees){
			%>
			<option value="<%=emp.getEmployeeId()%>" <%if(task!=null&&task.getAssignedEmployee().getEmployeeId()==(task.getAssignedEmployeeId())){%>selected<%} %>><%=emp.getEmployeeName() %></option>
			<%}} %>
			</select>
		</div>
		<button type="submit"><%=(task!=null)?"update Task":"Add Task"%></button>
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>S.No</th>
				
				<th>Task ID</th>
				<th>Task Name</th>
				<th>Description</th>
				<th>Priority</th>
				<th>Status</th>
				<th>AssignedEmployeeId</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Task> tasks = (List<Task>) request.getAttribute("tasks");
			int count = 1;

			if (tasks != null) {
				for (Task t : tasks) {
			%>

			<tr>
				<td><%=count++%>
				<td><%=t.getTaskId()%></td>
				<td><%=t.getTaskTitle()%></td>
				<td><%=t.getDescription()%></td>
				<td><%=t.getPriority()%></td>
				<td><%=t.getStatus()%></td>
				<td><%=t.getAssignedEmployee().getEmployeeId()%></td>
				<td><a href="task/edit/<%=t.getTaskId()%>"><button>Edit</button></a></td>
				<td><a href="task/delete/<%=t.getTaskId()%>" onclick="return confirm('are you sure to delete')"><button >Delete</button></a></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
</body>
</html>