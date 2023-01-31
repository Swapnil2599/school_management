<%@page import="entity.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("swapnil");
	EntityManager em = emf.createEntityManager();
	
	Student s = em.find(Student.class,id1);

%>

<form action="update" method="post">
id:<input type="text" value="<%= s.getId() %>" name="id">
name:<input type="text" value="<%= s.getName() %>" name="name">
age:<input type="text" value="<%= s.getAge() %>" name="age">
mobileno:<input type="text" value="<%= s.getMobileno() %>" name="no">
<input type="submit">
</form>

</body>
</html>