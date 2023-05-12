package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bookstore.entity.Users;

public class JpaDAO<E> {

	private static EntityManagerFactory entityManagerFactory;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	}
	
	public JpaDAO() {
	}

	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return entity;
	}
	
	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entity = entityManager.merge(entity);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return entity;
	}
	
	public E find(Class<E> type,Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		E entity = entityManager.find(type, id);
		if(entity!=null)
		   entityManager.refresh(entity);
		return entity;
	}
	
     public void delete(Class<E> type, Object id) {
    	 EntityManager entityManager = entityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
    	 E entity = entityManager.getReference(type, id);
    	 entityManager.remove(entity);
    	 entityManager.getTransaction().commit();
     }
     
     @SuppressWarnings("unchecked")
     
	public Users findWithNamedQuery(String queryName,String paramName,String paramValue) {
    	 System.out.println(paramName);
    	 System.out.println(paramValue);
    	 EntityManager entityManager = entityManagerFactory.createEntityManager();
    	 Query query = entityManager.createNamedQuery(queryName);
         query.setParameter(paramName, paramValue);
          List<Users> user = query.getResultList();
          if(user.isEmpty()||user==null)
               return null;
          else
        	 return  user.get(0);
     }
     
     @SuppressWarnings("unchecked")
	public List<E> findWithNamedQuery(String queryName){
    	 EntityManager entityManager = entityManagerFactory.createEntityManager();
    	 Query query = entityManager.createNamedQuery(queryName);
    	 return query.getResultList();
     }
     public long countWithNamedQuery(String queryName) {
    	 EntityManager entityManager = entityManagerFactory.createEntityManager();
    	 Query query = entityManager.createNamedQuery(queryName);
    	 return (long) query.getSingleResult();
     }
}
