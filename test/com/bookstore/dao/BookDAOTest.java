package com.bookstore.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookDAOTest {
   private static BookDAO bookDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookDAO = new BookDAO();
	}


//	@Test
//	public void create() throws ParseException, IOException {
//		
//		Book book =new Book();
//		Category category=new Category();
//		category.setName("Advance Java");
//		category.setCategoryId(2);
//		book.setCategory(category);
//		book.setTitle("Effective Java (2nd Edition)");
//		book.setAuthor("Joshua Bloch");
//		book.setDescription("Are you looking for a deeper understanding of the Java™ programming language so");
//		book.setIsbn("0321356683");
//		book.setPrice(38.87f);
//	SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
//	Date publisheDate = dateFormat.parse("05/28/2008");
//	book.setPublished(publisheDate);
//	String path="D:\\udemyProjectMaterial\\dummy-data-books\\books\\Effective Java.jpg";
//	
//	FileInputStream fis=new FileInputStream(new File(path));
//	byte[] imagedata=new byte[(int) new File(path).length()];
//	fis.read(imagedata);
//	book.setImage(imagedata);
//	  Book savedBook = bookDAO.create(book);
//	  System.out.println(savedBook);
//	  assertTrue(savedBook.getBookId()>0);
//	}
//
//	@Test
//	public void update() throws ParseException, IOException {
//		
//		Book book =new Book();
//		Category category=new Category();
//		category.setName("Core Java");
//		category.setCategoryId(1);
//		book.setCategory(category);
//		book.setTitle("Effective Java (3rd Edition)");
//		book.setAuthor("Joshua Bloch");
//		book.setDescription("Are you looking for a deeper understanding of the Java™ programming language so");
//		book.setIsbn("0321356683");
//		book.setPrice(40.85f);
//	SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
//	Date publisheDate = dateFormat.parse("05/28/2008");
//	book.setPublished(publisheDate);
//	String path="D:\\udemyProjectMaterial\\dummy-data-books\\books\\Effective Java.jpg";
//	
//	FileInputStream fis=new FileInputStream(new File(path));
//	byte[] imagedata=new byte[(int) new File(path).length()];
//	fis.read(imagedata);
//	book.setImage(imagedata);
//	  Book savedBook = bookDAO.create(book);
//	  System.out.println(savedBook);
//	  assertTrue(savedBook.getBookId()>0);
//	}
//	
//	@Test(expected = EntityNotFoundException.class)
//	public void deleteFail() {
//		int id=10;
//	bookDAO.delete(id);
//	}
//	
//	@Test(expected = EntityNotFoundException.class)
//	public void findFail() {
//		int id=10;
//	Book book = bookDAO.get(id);
//	System.out.println(book);
//	}
//	
//	@Test
//	public void findSuccess() {
//		int id=3;
//	Book book = bookDAO.get(id);
//	System.out.println(book);
//	}
//	@Test
//	public void findBook() {
//	int id=3;
//	Book book = bookDAO.get(id);
//	System.out.println(book);
//	}
//	@Test
//	public void deleteSuccess() {
//		int id=1;
//	bookDAO.delete(id);
//	}
//	@Test
//	public void findAllBook() {
//		List<Book> list = bookDAO.getAll();
//		list.forEach(obj->{System.out.println(obj);});
//	}
//	@Test
//	public void findByTitle() {
//		String title="Effective Java (3rd Edition)";
//		List<Book> list = bookDAO.findByTitle(title);
//		list.forEach(obj->{System.out.println(obj);});
//	}
	@Test
	public void findByCategory() {
	int id=22;
	List<Book> listOfBookByCategory = bookDAO.listOfBookByCategory(id);
	System.out.println(listOfBookByCategory);
	assertTrue(listOfBookByCategory.size()>0);
	}

//	@Test
//	public void count() {
//		long count = bookDAO.count();
//		System.out.println(count);
//	}
	
	@Test
	public void recentBook() {
		List<Book> recentPublishedBook = bookDAO.recentPublishedBook();
	  for (Book book : recentPublishedBook) {
		System.out.println(book.getTitle()+ "--"+book.getPublished());
	 }
		assertEquals(3,recentPublishedBook.size() );
	}
	@Test
	public void bookBySearch() {
		String keyword="java";
		List<Book> list = bookDAO.findBookBySearchKeyword(keyword);
		for ( Book book : list) {
			System.out.println(book.getTitle());
		}
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
