package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.services.CategoryService;

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO dao= new CategoryDAO();
		List<Category> categoryList = dao.getAll();
		request.setAttribute("categorylist", categoryList);
		BookDAO book=new BookDAO();
		List<Book> bookList = book.recentPublishedBook();
		request.setAttribute("bookList", bookList);
		String homePage = "frontend/index.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(homePage);
		requestDispatcher.forward(request, response);
	}

}
