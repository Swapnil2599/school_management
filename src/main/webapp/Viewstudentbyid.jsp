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
<title>View Student By Id</title>
</head>
<body>

<%
String id = request.getParameter("id");
int id1 = Integer.parseInt(id);

EntityManagerFactory emf = Persistence.createEntityManagerFactory("swapnil");
EntityManager em = emf.createEntityManager();

Student s = em.find(Student.class,id1);
out.println(s.getId());
out.println(s.getName());
out.println(s.getAge());
out.println(s.getMobileno());

//RequestDispatcher rd = request.getRequestDispatcher("Student.html");
//rd.forward(request, response);
%>

</body>
</html>