package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Model;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String name=request.getParameter("name");
	String custid=request.getParameter("custid");
	String saccno=request.getParameter("accno");
	int accno=Integer.parseInt(saccno);
	
	String pwd=request.getParameter("pwd");
	
	String sbal=request.getParameter("bal");
	int bal=Integer.parseInt(sbal);
	
	String email=request.getParameter("email");
	
	try {
		Model m=new Model();
		m.setName(name);
		m.setAccno(accno);
		m.setBal(bal);
		m.setCustid(custid);
		m.setEmail(email);
		m.setPwd(pwd);
		
		boolean b=m.register();
		
		if(b==true)
		{
			response.sendRedirect("/BankingApplication/SuccessReg.html");
		}
		{
			response.sendRedirect("/BankingApplication/FailureReg.html");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}

}
