<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entities.Department"%>
<%@page import="java.util.List"%>
<%@page import="service.DepartmentServiceImplementation"%>
<%@page import="service.DepartmentService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> Showing all the Departments </h1>	
	<%
		DepartmentService deptService = new DepartmentServiceImplementation();
		List<Department> deptList = deptService.findDepartmentsService();
	%>
	<table border=5 cellspacing=10 cellpadding=10>
		<tr>
			<th> DEPT NO </th>
			<th> DEPT NAME </th>
			<th> DEPT LOCATION </th>
		</tr>
	<% for(Department dept : deptList) { %>
		<tr>
			<td> <%=dept.getDepartmentNumber() %></td>
			<td> <input type=text name="dname" value="<%=dept.getDepartmentName()%>"></td>
			<td> <%=dept.getDepartmentLocation() %></td>
			<td> <button>Update</button></td>
			<td> <button>Delete</button></td>
			
		
		</tr>
	<% } %>
	</table>
	
		<a href="index.html"> Go Back Home</a>
	
	
</body>
</html>