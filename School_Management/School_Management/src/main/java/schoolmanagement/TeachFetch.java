package schoolmanagement;

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
@WebServlet("/TFetch")
public class TeachFetch extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String id=req.getParameter("id");
		  int id1=Integer.parseInt(id);
		  
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("veer");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t=em.find(Teacher.class, id1);
		System.out.println(t.getId());
		System.out.println(t.getTname());
		System.out.println(t.getSubject());
		System.out.println(t.getSalary());
		
        et.begin();  em.persist(t);   et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Data Fetched Succesfully");
		
		RequestDispatcher rd=req.getRequestDispatcher("Teacher.html");
		rd.forward(req, resp);
	}
}