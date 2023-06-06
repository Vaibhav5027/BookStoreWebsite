package com.bookstore.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryService {
private CategoryDAO categoryDao;

public CategoryService() {
	categoryDao=new CategoryDAO();
}
	
	public void categoryList(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
		  List<Category> categoryList = categoryDao.getAll();
		  request.setAttribute("categoryList", categoryList);
			if(msg!=null) {
				request.setAttribute("message", msg);
			}
			String listpage="category_list.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(listpage);
			requestDispatcher.forward(request, response);
			
	}
	
	public void createCategory(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
		 
		   Category res = categoryDao.findWithName(name);
		   System.out.println(res);
		 if(res!=null) {
				String message="Could not create category because category with this name is already available";
				request.setAttribute("message", message);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
				requestDispatcher.forward(request, response);
		 }
		 else {
			 Category category=new Category(name);

			categoryDao.create(category);
			categoryList(request, response,"New Category Created Succesfully");
		 }
	}
  
	public void editCategory(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Category category = categoryDao.find(Category.class, id);
		request.setAttribute("category", category);
		String edit_page="category_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(edit_page);
		requestDispatcher.forward(request, response);
	}
	
	public void updateCategory(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("categoryId"));
		String name = request.getParameter("name");
	
		 Category categoryByName = categoryDao.findWithName(name);
		 Category categoryById = categoryDao.get(id);

		if(categoryByName!=null && categoryByName.getCategoryId()!=categoryByName.getCategoryId()) {
			String msg="Category already available with name  :"+name +" please change the categoryName";
			request.setAttribute("message", msg);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}
       Category category=new Category(id,name);
		categoryDao.update(category);
		
		categoryList(request,response,"User Updated Succesfully");

	}
	
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 String parameter = request.getParameter("id");
		 categoryDao.delete(Integer.parseInt(parameter));
		 categoryList(request, response,"Category deleted succesfully");
		
	}
}
