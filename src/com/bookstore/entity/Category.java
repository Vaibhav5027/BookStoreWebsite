package com.bookstore.entity;
// Generated 4 Apr, 2023 1:36:58 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "bookstoredb")
@NamedQueries({
	@NamedQuery(name="Category.findAll", query = "select c from Category c ORDER BY c.name"),
	@NamedQuery(name = "Category.countAll", query = "SELECT COUNT(c) FROM Category c")
})
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer categoryId;
	private String name;
	private Set<Book> books = new HashSet<Book>(0);
	private Set<BookTable> bookTables = new HashSet<BookTable>(0);

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(String name, Set<Book> books, Set<BookTable> bookTables) {
		this.name = name;
		this.books = books;
		this.bookTables = bookTables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<BookTable> getBookTables() {
		return this.bookTables;
	}

	public void setBookTables(Set<BookTable> bookTables) {
		this.bookTables = bookTables;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}

}
