package com.bookstore.services;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookServices {

	private BookDAO bookDao;
	private CategoryDAO categoryDao;

	public BookServices() {
		super();
		bookDao = new BookDAO();
		categoryDao = new CategoryDAO();
	}

	public void listAllBook(HttpServletRequest request, HttpServletResponse response, String msg)
			throws ServletException, IOException {
		List<Book> booklist = bookDao.getAll();
		if (booklist != null)
			request.setAttribute("booklist", booklist);
		if (msg != null)
			request.setAttribute("message", msg);
		String page = "book_list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

	public void showBookFormPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categoryList = categoryDao.getAll();
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_form.jsp");
		requestDispatcher.forward(request, response);
	}

	public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		List<Book> existedBook = bookDao.findByTitle(title);
		if (!existedBook.isEmpty()) {
			String message = "could not create new book because" + title + "is already present";
			request.setAttribute("message", message);
			listAllBook(request, response, message);
		}
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishedDate = null;
		try {
			publishedDate = dateFormat.parse(request.getParameter("publisheddate"));
		} catch (ParseException e) {
			throw new ServletException("please enter date in format 'mm/dd/yyyy'");
		}

		Book newBook = new Book();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setIsbn(isbn);
		newBook.setDescription(description);
		newBook.setPrice(price);
		Category category = categoryDao.get(categoryId);
		newBook.setCategory(category);
		newBook.setPublished(publishedDate);

		Part part = request.getPart("bookImage");
		if (part != null || part.getSize() > 0) {
			long size = part.getSize();

			byte[] imageBytes = new byte[(int) size];
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			newBook.setImage(imageBytes);
		}

		Book createdBook = bookDao.create(newBook);
		if (createdBook != null || createdBook.getBookId() > 0) {
			String message = "new book created succesfully";
			request.setAttribute("message", message);
			listAllBook(request, response, message);
		} else {

		}
	}

	public void editBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parameter = request.getParameter("id");
		Integer id = Integer.parseInt(parameter);
		Book book = bookDao.find(Book.class, id);
		List<Category> categoryList = categoryDao.getAll();
		if (book != null) {
			request.setAttribute("book", book);
			System.out.println(book.getBookId());
			request.setAttribute("categoryList", categoryList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_form.jsp");
			requestDispatcher.forward(request, response);
		}

		else {
			String destPage = "message.jsp";
			String message = "Could not find book with ID " + id;
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}

	}

	public void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("bookId"));
//		   Book book = bookDao.find(Book.class, id);

		String title = request.getParameter("title");
		Book book = bookDao.get(id);
		List<Book> bookByTitle = bookDao.findByTitle(title);
		if (!bookByTitle.isEmpty()) {
			if (!book.equals(bookByTitle.get(0))) {
				String msg = "Another book is existed with this title we cant update";
				listAllBook(request, response, msg);
			}
		}
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");
		int categoryId = Integer.parseInt(request.getParameter("category"));
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishedDate = null;
		try {
			publishedDate = dateFormat.parse(request.getParameter("publisheddate"));
		} catch (ParseException e) {
			throw new ServletException("please enter date in format 'mm/dd/yyyy'");
		}
		book.setTitle(title);
		book.setAuthor(author);
		book.setIsbn(isbn);
		book.setDescription(description);
		book.setPrice(price);

		Category category = categoryDao.get(categoryId);
		book.setCategory(category);
		book.setPublished(publishedDate);

		Part part = request.getPart("bookImage");
		if (part != null || part.getSize() > 0) {
			long size = part.getSize();

			byte[] imageBytes = new byte[(int) size];
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			book.setImage(imageBytes);
		}

		Book update = bookDao.update(book);
		if (update != null) {
			String message = "Book updated Succesfully";
			listAllBook(request, response, message);
		}

	}

	public void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.find(Book.class, id);
		if (book != null) {
			bookDao.delete(Book.class, id);
			String message = "Book succesfully deleted with id::" + id;
			listAllBook(request, response, message);
		}
		if (book == null) {

			String message = "Could not find book with ID " + id

					+ ", or it might have been deleted";

			request.setAttribute("message", message);

			request.getRequestDispatcher("message.jsp").forward(request, response);
		}

	}

	public void bookListByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Book> listOfBook = bookDao.listOfBookByCategory(id);
		Category category = categoryDao.get(id);
		Integer categoryId = category.getCategoryId();
		String name = category.getName();

		if (!listOfBook.isEmpty()) {
			CategoryDAO dao = new CategoryDAO();
			List<Category> categoryList = dao.getAll();
			request.setAttribute("categorylist", categoryList);
			request.setAttribute("name", name);
			request.setAttribute("booklist", listOfBook);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/frontend/view_books_by_category.jsp");
			requestDispatcher.forward(request, response);
		}

		else {
			String message = "Something Wrong please contact for admin";
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

	public void getBookDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.find(Book.class, id);
		if (book != null) {
			CategoryDAO dao = new CategoryDAO();
			List<Category> categoryList = dao.getAll();
			request.setAttribute("categorylist", categoryList);
			String page = "frontend/view_book.jsp";
			request.setAttribute("book", book);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
		} else {
			String message = "Something Wrong please contact for admin";
			request.setAttribute("message", message);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

	public void findBookByKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		CategoryDAO dao= new CategoryDAO();
		List<Category> categoryList = dao.getAll();
		 List<Book>  books=null;
		 request.setAttribute("keyword", keyword);
		 if(!keyword.isEmpty() || keyword!=null )
		    books = bookDao.findBookBySearchKeyword(keyword);
	  
		if(!books.isEmpty()) {
			request.setAttribute("categorylist", categoryList);
			request.setAttribute("books", books);
			String page="frontend/searched_book.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
		}
		else {
			request.setAttribute("categorylist", categoryList);
			String page="frontend/searched_book.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
		}
		
	}
}