package com.org.book.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.org.book.cart.Cart;
import com.org.book.cart.CartItem;
import com.org.book.sslConfig.SslConfig;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handles all the Http Get and Post requests to confirm the order for a user after payment details are provided
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ConfirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the purchase order Id
		int purchaseorderid = (int) request.getSession(false).getAttribute("POID");
    	
    	//Get the cart Items
    	Cart cartItems = (Cart) request.getSession(false).getAttribute("items_in_cart");
    	List<CartItem> cartitems = cartItems.getBookcart();
    	
    	SslConfig sslconf= new SslConfig();
    	Client client = sslconf.ssl(); 
    	
		String URL= "https://localhost:8443/OnlineBookStore/rest/OrderProcess/confirmOrder";
		WebTarget target = client.target(URL).path("/{POID}").resolveTemplate("POID", purchaseorderid);
		Invocation.Builder ib = target.request(MediaType.TEXT_PLAIN);
		Response res = ib.put(Entity.entity(cartitems, MediaType.APPLICATION_JSON));
		
		boolean confirm = res.readEntity(boolean.class);
		String action = null;
		if(confirm == true) {
			action = "Order Successfully Placed";
		}
		else
		{
			action = "Credit Card Authorization Denied";
		}
		request.getSession(false).setAttribute("order_status", action);
		response.sendRedirect("confirmation.jsp");
    	
		
	}
			
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConfirmOrder(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConfirmOrder(request, response);
	}

}
