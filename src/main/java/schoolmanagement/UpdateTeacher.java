package schoolmanagement;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ajit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Teacher t=new Teacher();
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String sub=req.getParameter("sub");
		String sal=req.getParameter("sal");
		et.begin();
		em.merge(t);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
		rd.forward(req, resp);
	}

}
