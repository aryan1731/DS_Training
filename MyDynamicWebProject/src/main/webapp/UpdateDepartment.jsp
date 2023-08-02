<%@page import="service.DepartmentServiceImplementation"%>
<%@page import="java.util.List"%>
<%@page import="entities.Department"%>
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
	<%
		DepartmentService deptService = new DepartmentServiceImplementation();
	
		int existingDeptNumber=Integer.parseInt(request.getParameter("dno")); //read from HTML
		String newDeptName = request.getParameter("dname");
		String newDeptLoc = request.getParameter("dloc");
		
		Department dept = new Department();
		dept.setDepartmentNumber(existingDeptNumber);
		dept.setDepartmentName(newDeptName);
		dept.setDepartmentLocation(newDeptLoc);
		
		deptService.modifyDepartmentService(dept);
		
		
	%>
			<h2> New Department Modified </h2>
			<a href="index.html"> Go Back Home</a>
	
</body>
</html>