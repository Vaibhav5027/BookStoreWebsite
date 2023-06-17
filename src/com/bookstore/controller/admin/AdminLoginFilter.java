package com.bookstore.controller.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter

{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	HttpServletRequest httpRequest=	(HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
	
	boolean loggedin = session!=null  && session.getAttribute("useremail")!=null;
	String loginURI=httpRequest.getContextPath() +"/admin/login";
	boolean loggedIn = httpRequest.getRequestURI().equals(loginURI);
	boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
	if(loggedin && (loggedIn || loginPage)) {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
		requestDispatcher.forward(httpRequest, response);	
	}
	else if(loggedin ||loggedIn) {
			System.out.println("logged in");
		   chain.doFilter(request, response);
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(httpRequest, response);
			System.out.println("not logged in");
		}
	}

	@Override
	public void destroy() {
		
	}

}
