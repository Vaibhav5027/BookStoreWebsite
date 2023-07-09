package com.bookstore.dao;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookstore.entity.Book;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {
   
	
	@Override
	public Book create(Book book) {
		book.setUpdatedOn(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		book.setUpdatedOn(new Date());

		return super.update(book) ;
	}

	@Override
	public Book get(Object id) {
		return super.find(Book.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Book.class, id);
		
	}

	@Override
	public List<Book> getAll() {
		return super.findWithNamedQuery("Book.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Book.countAll");
	}
	
	public List<Book> findByTitle(String title) {
		return super.findWithNamedQuery("Book.findByTitle", "title", title);
	}
   public List<Book> listOfBookByCategory(Integer catId){
	   return super.findWithNamedQuery("Book.findByCategory","catId",catId);
   }
 public List<Book> recentPublishedBook(){
	 EntityManager entityManger = super.getEntityManger();
	    Query query = entityManger.createNamedQuery("Book.listNewBook");
	    query.setFirstResult(0);
	    query.setMaxResults(3);
        return query.getResultList();
 }
 public List<Book> findBookBySearchKeyword(String keyword){
	 return super.findWithNamedQuery("Book.bySearch","keyword",keyword);
 }
}
