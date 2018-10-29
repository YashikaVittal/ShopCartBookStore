package com.org.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Method to handle Http requests and response for user logout and clear session attributes
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ClearSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		String page=null;
		
		if("BackToShop".equals(operation)) {
			HttpSession session = request.getSession(false);
			session.removeAttribute("items_in_cart");
			session.removeAttribute("POID");
			page = "allBook";
			
		}
		
		if("LogOut".equals(operation)) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			page = "logout.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClearSession(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClearSession(request, response);
	}

}
