package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.services.UserServices;


@WebServlet("/admin/update_user")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserServices services=new UserServices();
		services.updateUser(request,response);
	}

}
