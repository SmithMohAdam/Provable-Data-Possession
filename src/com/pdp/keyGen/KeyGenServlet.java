package com.pdp.keyGen;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KeyGenServlet
 */
@WebServlet(urlPatterns={"/KeyGenServlet"})
public class KeyGenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//int temp =(int) request.getAttribute("pass");
		
		Key keyObj = new Key(60);
		
		request.getSession().setAttribute("key",keyObj);
	    RequestDispatcher dis = request.getRequestDispatcher("succes.jsp");
	    dis.forward(request, response);
		System.out.println("The public Key is :" + keyObj.getPublickey());
		System.out.println("The private Key is :" + keyObj.getPrivatekey());
	}

}
