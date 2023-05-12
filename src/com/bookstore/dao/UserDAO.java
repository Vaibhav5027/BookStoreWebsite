package com.bookstore.dao;

import java.util.List;



import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO() {
	}

	public Users create(Users user) {
		return super.create(user);
	}
	
	@Override
	public Users update(Users user) {
		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object id) {
		super.delete(Users.class, id);
		
	}

	@Override
	public List<Users> getAll() {
		
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
	}
    
	public Users findByEmail(String email) {
	  Users users = super.findWithNamedQuery("Users.findByEmail", "email", email);
	 
	   
	  return users;
	}
}
