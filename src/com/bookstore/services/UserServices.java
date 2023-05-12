package com.bookstore.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {
	private UserDAO userDAO;
	public UserServices() {
		userDAO=new UserDAO();
	}

	public List<Users> listUser(HttpServletRequest request,HttpServletResponse response,String msg) throws ServletException, IOException {
		List<Users> userList = userDAO.getAll();
		request.setAttribute("userlist", userList);
		if(msg!=null) {
			request.setAttribute("message", msg);
		}
		String listpage="user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listpage);
		requestDispatcher.forward(request, response);
		return userList;
	}

	public void createUser(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String fullname=request.getParameter("fullname");

		Users existEmail = userDAO.findByEmail(email);
		System.out.println(existEmail);
		if(existEmail !=null) {
			String message="Could not create user because user with this "+email+" exit with this email id";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			Users user=new Users(email,fullname,password);

			userDAO.create(user);
			listUser(request, response,"New User Created Succesfully");

		}
	}

	public void editUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.find(Users.class, id);
		request.setAttribute("user", user);
		String edit_page="user_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(edit_page);
		requestDispatcher.forward(request, response);
	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		System.out.println(email+ " " +fullname+" "+password);
		Users userByEmail = userDAO.findByEmail(email);
		Users userById = userDAO.get(id);

		if(userByEmail!=null && userByEmail.getUserId()!=userById.getUserId()) {
			String msg="User already available with email id: "+email +" please change the emailid";
			request.setAttribute("message", msg);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}

		Users user=new Users(id,email,fullname,password); 
		userDAO.update(user);
		listUser(request,response,"User Updated Succesfully");

	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 int id=Integer.parseInt(request.getParameter("id"));
	 System.out.println(id);
	    userDAO.delete(id);
		listUser(request, response,"user deleted succesfully");
	}

}
