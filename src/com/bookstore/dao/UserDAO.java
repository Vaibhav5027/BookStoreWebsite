package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO() {
	}

	public Users create(Users user) {
		String encryptedPassword = HashGenerator.generateMD5(user.getPassword());
		user.setPassword(encryptedPassword);
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
	  List<Users> users = super.findWithNamedQuery("Users.findByEmail", "email", email);
	     if(users!=null && users.size()>0)
	    	 return users.get(0);
	     else
	    	 return null;
	}
	
	public boolean checkLogin(String email ,String password) {
		Map<String, Object> hashMap = new HashMap<>();
		String encryptedPassword = HashGenerator.generateMD5(password);
		hashMap.put("email", email);
		hashMap.put("password", encryptedPassword);
		List<Users> listresult = super.findWithNamedQuery("Users.findByEmailAndPassword", hashMap);
		if(listresult.size()>=1)
			return true;
		return false;
	}
}
