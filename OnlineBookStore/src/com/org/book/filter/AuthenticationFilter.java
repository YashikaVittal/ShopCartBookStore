package com.org.book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class is referred from - https://www.journaldev.com/1933/java-servlet-filter-example-tutorial
 * 
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		HttpSession session = req.getSession(false);
		
		//The below check is modified from the example to suit our project requirements
		if(session != null)
		{
			String cust_name = (String) session.getAttribute("customername");
			
			//The customer name in the session is not set
			//Redirect to Login page if CreateOrderServlet and ConfirmOderServlet is called without user being logged in
			if(cust_name == null && (uri.endsWith("CreateOrderServlet" ) || uri.endsWith("ConfirmOrderServlet"))) {
				this.context.log("Unauthorized access request");
				res.sendRedirect("login.jsp");
			}
			else
			{	
				this.context.log("chain.doFilter");
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}
		else
		{
			this.context.log("chain.doFilter");
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		//close any resources here
	}

}
