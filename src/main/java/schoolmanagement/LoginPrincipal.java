package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ganu")
public class LoginPrincipal extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ajit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select u from Principal u where u.email=?1 and u.password=?2");
		
		q.setParameter(1,email);
		q.setParameter(2,password);
		
		List<Principal> principal=q.getResultList();
		
		if(principal.size()==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("serverST.html");
			rd.forward(req, resp);
		}
		else {
			PrintWriter pw=resp.getWriter();
			pw.write("invalid");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
	}

}
