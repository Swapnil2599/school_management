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

import entity.Teacher;

@WebServlet("/add1")
public class TeacherAddData extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String salary = req.getParameter("salary");
		String subject = req.getParameter("sub");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("swapnil");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Teacher t = new Teacher();
		t.setId(Integer.parseInt(id));
		t.setName(name);
		t.setSalary(Double.parseDouble(salary));
		t.setSub(subject);
		
		et.begin();
		em.persist(t);
		et.commit();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("Data added successfully...");

		RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");
		rd.include(req, resp);

	}

}
