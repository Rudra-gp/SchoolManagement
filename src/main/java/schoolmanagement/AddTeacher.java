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
@WebServlet("/addteacher")
public class AddTeacher extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String sub=req.getParameter("sub");
		String sal=req.getParameter("sal");
		
		Teacher t=new Teacher();
		t.setId(id);
		t.setName(name);
		t.setSub(sub);
		t.setSal(sal);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Ajit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(t);
		et.commit();
		RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
		rd.forward(req, resp);

}
}
