/**
 * 
 */
package net.codejava.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.codejava.hibernate.Book;
import net.codejava.hibernate.BookManager;

/**
 * @author adityasuraj
 *
 */
@Path("/hello")
public class BookRestController {

	BookManager manager = new BookManager();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBookById")
	public Book getBookById(@NotNull @QueryParam("bookId") long bookId) {
		manager.setUp();
		
		Book book = manager.read(bookId);
		
		manager.exit();
		if(book != null) {
			System.out.println(book.getId());
			System.out.println(book.getAuthor());
			System.out.println(book.getPrice());
			System.out.println(book.getTitle());
		}
		else {
			System.out.println("No book found");
		}
		
		return book;
	}

	@POST
	@Path("/createBook")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createBook(Book book) {
		manager.setUp();
		manager.create(book);
		manager.exit();
	}
	
	@PUT
	@Path("/updateBookById")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBookById(Book book, @NotNull @QueryParam("bookId") long bookId) {
		manager.setUp();
		book.setId(bookId);
		manager.update(book);
		manager.exit();
	}
	
	@DELETE
	@Path("/deleteBookById")
	public void deleteBookById(@NotNull @QueryParam("bookId") long bookId) {
		manager.setUp();
		manager.delete(bookId);
		manager.exit();
	}
}
