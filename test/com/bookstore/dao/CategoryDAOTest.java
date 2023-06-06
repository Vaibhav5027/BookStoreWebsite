package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest {

	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDAO  = new CategoryDAO();
	}


	@Test
	public void testGet() {
		Integer id=1;
		Category category = categoryDAO.get(id);
		System.out.println(category);
		assertNotNull(category);
	}

	@Test
	public void testDeleteObject() {

		Integer id=7;
		categoryDAO.delete(id);
	}

	@Test
	public void testGetAll() {
		List<Category> list = categoryDAO.getAll();
		System.out.println(list);
		assertTrue(list.size()>0);

	}

	@Test
	public void testCount() {
		long count = categoryDAO.count();
		System.out.println(count);
		assertTrue(count>0);
	}

	@Test
	public void testCreate() {
		Category category=new Category("Java");
		Category cgry = categoryDAO.create(category);
		assertTrue(cgry!=null && cgry.getCategoryId()>0);


	}

	@Test
	public void testUpdate() {
		Category category=new Category("Comedy");
		category.setCategoryId(2);
		Category cgry = categoryDAO.update(category);
		assertEquals(category.getName(), cgry.getName());

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
