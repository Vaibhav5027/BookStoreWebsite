package com.bookstore.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.services.BookServices;

/**
 * Servlet implementation class CreateNewBookServlet
 */
@WebServlet("/admin/create_book")
@MultipartConfig(
		fileSizeThreshold = 1024 *10,//10kb
		maxFileSize = 1024*500,  //500kb
		maxRequestSize=1024*1024 //1mb
		)
public class CreateNewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BookServices service=new BookServices();
	service.addBook(request, response);
	}

}
