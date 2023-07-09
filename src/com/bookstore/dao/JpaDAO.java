package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class JpaDAO<E> {

	private static EntityManagerFactory entityManagerFactory;
	EntityManager entityManager=null;
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
	}
	
	public JpaDAO() {
	}

	public EntityManager getEntityManger() {
		return entityManagerFactory.createEntityManager();
	}
	public E create(E entity) {
	entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager.close();
		return entity;
	}
	
	public E update(E entity) {
		 entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entity = entityManager.merge(entity);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return entity;
	}
	
	public E find(Class<E> type,Object id) {
		 entityManager = entityManagerFactory.createEntityManager();
		E entity = entityManager.find(type, id);
		if(entity!=null)
		   entityManager.refresh(entity);
		entityManager.close();
		return entity;
	}
	
     public void delete(Class<E> type, Object id) {
    entityManager = entityManagerFactory.createEntityManager();
    	entityManager.getTransaction().begin();
    	 E entity = entityManager.getReference(type, id);
    	 entityManager.remove(entity);
    	 entityManager.getTransaction().commit();
    	 entityManager.close();
     } 
	public List<E> findWithNamedQuery(String queryName,String paramName,Object paramValue) {
    	  entityManager = entityManagerFactory.createEntityManager();
    	 Query query = entityManager.createNamedQuery(queryName);
         query.setParameter(paramName, paramValue);
          @SuppressWarnings("unchecked")
		List<E> result = query.getResultList();
          entityManager.close();
          return result;
     }
     
     @SuppressWarnings("unchecked")
 	public List<E> findWithNamedQuery(String queryName,Map<String,Object> parameters) {
 		 entityManager = entityManagerFactory.createEntityManager();
    	 Query query = entityManager.createNamedQuery(queryName);
    	  Set<Entry<String, Object>> entrySet = parameters.entrySet();
    	  for (Entry<String, Object> entry : entrySet) {
			query.setParameter(entry.getKey(), entry.getValue());
		} 	 
		List<E> result = query.getResultList();
		entityManager.close();
         return result;
    }
     
     @SuppressWarnings("unchecked")
	public List<E> findWithNamedQuery(String queryName){
    	 entityManager = entityManagerFactory.createEntityManager();
    	 Query query = entityManager.createNamedQuery(queryName);
                  List resultList = query.getResultList();
             	 entityManager.close();
    	 return resultList;
     }
     public long countWithNamedQuery(String queryName) {
    	  entityManager = entityManagerFactory.createEntityManager();
    	 Query query = entityManager.createNamedQuery(queryName);
    	 Long result=(long) query.getSingleResult();
    	 
    	 return result;
     }
}
