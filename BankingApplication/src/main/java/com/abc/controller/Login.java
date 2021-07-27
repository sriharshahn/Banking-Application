package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.model.Model;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custid=request.getParameter("custid");
		String pwd=request.getParameter("pwd");
		session=request.getSession(true);
		try {
			Model m=new Model();
			m.setCustid(custid);
			m.setPwd(pwd);
			boolean b=m.login();
			if(b==true)
			{
				session.setAttribute("accno", m.getAccno());
				System.out.println("the accno getting is :"+m.getAccno());
				response.sendRedirect("/BankingApplication/Home.html");
			}
			else {
				response.sendRedirect("/BankingApplication/Error.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
