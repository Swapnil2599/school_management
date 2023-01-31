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

import entity.Principal;

@WebServlet("/one")
public class InsertDetails extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String mobileno = req.getParameter("no");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");

		int age1 = Integer.parseInt(age);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("swapnil");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Principal p = new Principal();
		p.setName(name);
		p.setAge(age1);
		p.setMobileno(mobileno);
		p.setEmail(email);
		p.setPassword(password);

		et.begin();
		em.persist(p);
		et.commit();

		System.out.println("Data saved...");
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("Account created successfully...");

		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.include(req, resp);

	}

}
