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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.org.book.model.User;
import com.org.book.sslConfig.SslConfig;

/**
 * Servlet implementation class RegisterControllerServlet
 */
@WebServlet("/RegisterControllerServlet")
public class RegisterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * Method to handle Http requests and response to register a new user in the website
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetching details entered by user from  registration form
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				String street = request.getParameter("street");
				String city = request.getParameter("city");
				String province = request.getParameter("province");
				String country = request.getParameter("country");
				String zip = request.getParameter("zip");
				String phone = request.getParameter("phone");
				String page=null;
				
				
				SslConfig sslconf= new SslConfig();
		    	Client client = sslconf.ssl(); 
				
				String URL= "https://localhost:8443/OnlineBookStore/rest/OrderProcess/registerUser";
				WebTarget target=client.target(URL).queryParam("fname", fname).queryParam("lname", lname).queryParam("pwd", pwd).queryParam("email", email).queryParam("street", street).queryParam("city", city).queryParam("province", province).queryParam("country", country).queryParam("zip" , zip).queryParam("phone", phone);
				
				Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
				Response res = ib.get();
				User user= res.readEntity(new GenericType<User>() {});
				HttpSession session = request.getSession(true);
				
				//Check if the user is registered successfully
				if(user != null)
				{
						session.setAttribute("errorMessage", "");
						//setting customerid to session
						session.setAttribute("customerid", user.getCustomerid());
						session.setAttribute("customername", user.getFname());
						
						page= "CreateOrderServlet";
				}
				else {
					//User not registred properly
					page= "login.jsp";
					session.setAttribute("errorMessage", "User Already exists");
				}
				
				request.setAttribute("user", user);
				request.getRequestDispatcher(page).forward(request, response);
			}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registerUser(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		registerUser(request,response);
	}
}
