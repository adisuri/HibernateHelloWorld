package net.codejava.hibernate;

import javax.persistence.*;


@Entity
@Table(name = "book")
public class Book {

	private long id;
	private String title;
	private String author;
	private float price;

	/**
	 * 
	 */
	public Book() {
	}

	/**
	 * @param id
	 * @param title
	 * @param author
	 * @param price
	 */
	public Book(String title, String author, float price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
