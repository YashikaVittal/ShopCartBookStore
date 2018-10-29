package com.org.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.org.book.model.User;
import com.org.book.sslConfig.SslConfig;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method to handle Http requests and response for user login
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void isUserValid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String email= request.getParameter("email");
		String pwd= request.getParameter("password");
		String page=null;

		SslConfig sslconf= new SslConfig();
    	Client client = sslconf.ssl(); 

		String URL= "https://localhost:8443/OnlineBookStore/rest/OrderProcess/isValidUser";
		WebTarget target=client.target(URL).queryParam("email", email);

		Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
		Response res = ib.get();
		User user= res.readEntity(User.class);
		HttpSession session = request.getSession(true);
		
		//Check if the user has an account
		if(user != null)
		{
			//User registered, so check for password
			if (pwd.equals(user.getPwd()))
			{
				session.setAttribute("errorMessage", "");
				
				//setting customerid to session
				session.setAttribute("customerid", user.getCustomerid());
				session.setAttribute("customername", user.getFname());

				//User details are correct and validated
				page= "CreateOrderServlet";
			}
			
			else {
				//User not valid
				page= "login.jsp";
				session.setAttribute("errorMessage", "Email not registered or Password incorrect");
			}
		}
		else {
			//User not valid
			page= "login.jsp";
			session.setAttribute("errorMessage", "Email not registered or Password incorrect");
		}

		request.getRequestDispatcher(page).forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		isUserValid(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		isUserValid(request, response);
	}

}
