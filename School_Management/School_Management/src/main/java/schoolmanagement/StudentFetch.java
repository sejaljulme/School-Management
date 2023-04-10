package schoolmanagement;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;
@WebServlet("/fetching")
public class StudentFetch extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("veer");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select s from Student s");
		List<Student> stud=q.getResultList();
		
		HttpSession hs=req.getSession();
		hs.setAttribute("Studentlist", stud);
		
		RequestDispatcher rd=req.getRequestDispatcher("StudentFetch.jsp");
		rd.include(req, resp);
		
	}

}
