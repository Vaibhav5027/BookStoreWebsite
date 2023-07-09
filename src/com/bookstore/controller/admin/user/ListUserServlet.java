package com.bookstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.services.UserServices;

@WebServlet("/admin/list_users")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListUserServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserServices services=new UserServices();
	services.listUser(request, response ,null);

	}

	

}
