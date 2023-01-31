<%@page import="entity.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Teacher</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("swapnil");
	EntityManager em = emf.createEntityManager();
	
	Teacher t = em.find(Teacher.class,id1);
%>

<form action="update1" method="post">
Id: <input type="text" value="<%= t.getId() %>" name="id">
Name: <input type="text" value="<%= t.getName() %>" name="name">
Salary: <input type="text" value="<%= t.getSalary() %>" name="salary">
Subject: <input type="text" value="<%= t.getSub() %>" name="sub">
<input type="submit">
</form>

</body>
</html>