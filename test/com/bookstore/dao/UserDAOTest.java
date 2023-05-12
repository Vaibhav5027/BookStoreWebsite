package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	private static UserDAO userDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDAO = new UserDAO();
	}

	@Test
	public void createUser() {
		Users user=new Users();
		user.setEmail("roshan@gmail.com");
		user.setFullName("Roshan Kumar");
		user.setPassword("roshan@123");
		userDAO.create(user);

	}
	
	@Test
	public void testFindByEmail() {
		String email="Rohit@Gmail.com";
		Users user = userDAO.findByEmail(email);
		System.out.println(user);
		
		assertNotNull(user);
	}


	@Test

	public void testUpdateUsers() {
		Users user = new Users();
user.setUserId(5);
		user.setEmail("name@codejava.net");
		user.setFullName("Nam Ha Minh");
		user.setPassword("mysecret");

		user = userDAO.update(user);
		String expected = "mysecret";
		String actual = user.getPassword();

		assertEquals(expected, actual);
	}
	@Test
	public void testGet() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if(user!=null)
			System.out.println(user.getEmail());
		assertNotNull(user);
	}

	@Test
	public void testGetUserNotFound() {
		Integer id=99;
		Users users = userDAO.get(id);
		assertNull(users);
	}

	@Test
	public void testDelete() {
		Integer id=3;
		userDAO.delete(id);
		Users users = userDAO.get(id);

		assertNull(users);
	}

	@Test(expected = EntityNotFoundException.class)
	public void testNotExistingEntity() {
		Integer id=3;
		userDAO.delete(id);

	}

	@Test
	public void testGetAll() {
		List<Users> users = userDAO.getAll();
		System.out.println(users.size());
		assertTrue(users.size()>0);
	}

	@Test
	public void countAll() {
		long count = userDAO.count();
		System.out.println(count);
		assertEquals(2,count);
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}
}
