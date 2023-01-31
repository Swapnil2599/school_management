package school_management;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Principal;

@WebServlet("/two")
public class LoginValidation extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("pass");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("swapnil");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select a from Principal a where a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);

		List<Principal> p = q.getResultList();

		if (p.size() > 0) 
		{
			resp.setContentType("text/html");
			PrintWriter pw1 = resp.getWriter();
			pw1.write("Login successful...");

			RequestDispatcher rd = req.getRequestDispatcher("teastu.html");
			rd.include(req, resp);
			
		} 
		else 
		{
			PrintWriter pw = resp.getWriter();
			pw.write("invalid credentials...");
			RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
			rd1.include(req, resp);
			resp.setContentType("text/html");

		}

	}

}
