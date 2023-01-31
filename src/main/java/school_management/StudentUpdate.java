package school_management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;

@WebServlet("/update")
public class StudentUpdate extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mobileno = req.getParameter("no");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("swapnil");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
		s.setId(Integer.parseInt(id));
		s.setName(name);
		s.setAge(Integer.parseInt(age));
		s.setMobileno(mobileno);
		
		et.begin();
		em.merge(s);
		et.commit();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("Updated successfully...");
		
		RequestDispatcher rd = req.getRequestDispatcher("Student.html");
		rd.include(req, resp);
		
	}

}
