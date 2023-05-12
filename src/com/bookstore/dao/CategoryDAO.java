package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	
	public Category create(Category category) {
		return super.create(category);
	}
	
	@Override
	public Category update(Category category) {
		return super.update(category);
	}
	
	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		 super.delete(Category.class, id);
	}

	@Override
	public List<Category> getAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}

}
