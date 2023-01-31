package school_management;

import java.io.IOException;

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

@WebServlet("/three")
public class StudentAddData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mobileno = req.getParameter("no");
		
		int id1 = Integer.parseInt(id);
		int age1 = Integer.parseInt(age);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("swapnil");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s = new Student();
		s.setId(id1);
		s.setName(name);
		s.setAge(age1);
		s.setMobileno(mobileno);

		et.begin();
		em.persist(s);
		et.commit();

		System.out.println("Data saved...");

		RequestDispatcher rd = req.getRequestDispatcher("Student.html");
		rd.forward(req, resp);

	}

}
