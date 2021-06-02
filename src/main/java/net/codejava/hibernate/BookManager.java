package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {

	protected SessionFactory sessionFactory;
	
	public void setUp(){
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public void exit() {
		sessionFactory.close();
	}
	
	public void create(Book book) {
//	    Book book = new Book();
//	    book.setTitle("Effective Java");
//	    book.setAuthor("Joshua Bloch");
//	    book.setPrice(32.59f);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.save(book);
	 
	    session.getTransaction().commit();
	    session.close();
	}
	
	public Book read(long bookId) {
	    Session session = sessionFactory.openSession();
	 
	    Book book = session.get(Book.class, bookId);
	 
//	    if(book!=null) {
//	    	System.out.println("Title: " + book.getTitle());
//		    System.out.println("Author: " + book.getAuthor());
//		    System.out.println("Price: " + book.getPrice());
//	    }else {
//	    	System.out.println("Book could not be found.");
//	    }
	    
	    session.close();
	    return book;
	}
	
	public void update(Book book) {
//	    Book book = new Book("Ultimate Java Programming","Nam Ha Minh",19.99f);
//	    book.setId(1);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.update(book);
	 
	    session.getTransaction().commit();
	    session.close();
	}
	
	public void delete(long bookId) {
	    Book book = new Book();
	    book.setId(bookId);
	 
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.delete(book);
	 
	    session.getTransaction().commit();
	    session.close();
	}
		
//	public static void main(String[] args) {
//		BookManager manager = new BookManager();
//		manager.setUp();
//		
//		manager.delete();
//		
//		manager.exit();
//
//	}

}
