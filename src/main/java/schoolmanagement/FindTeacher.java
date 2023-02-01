package schoolmanagement;

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
@WebServlet("/findteacher")
public class FindTeacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Ajit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		String id=req.getParameter("id");
		Teacher t=em.find(Teacher.class, id);
		System.out.println(t.getId());
		System.out.println(t.getName());
		System.out.println(t.getSub());
		System.out.println(t.getSal());
		
		RequestDispatcher rd=req.getRequestDispatcher("FindStudent.html");
		rd.forward(req, resp);
		
		
	}

}
