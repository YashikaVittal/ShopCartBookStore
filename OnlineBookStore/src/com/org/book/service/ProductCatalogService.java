package com.org.book.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.org.book.dao.BookDAO;
import com.org.book.model.Book;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/ProductCatalog")
public class ProductCatalogService {

	/**
	 *This Method all the books belonging to one category in the Database table Book
	 *
	 *@param category: category selected by the user
	 *@returns List<Book>: List of books available in that category
	 *
	 */
	@GET
	@Path("/getCategoryBooks/{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getIt(@PathParam("category") String category) {
		BookDAO book_dao = new BookDAO();
		List<Book> book = book_dao.getBookByCategory(category);
		return book;
	}

	/**
	 *  Method to get information about the book using the bookid provided
	 * 
	 * @param bookid
	 * @return Book details corresponding to bookid
	 */
	@GET
	@Path("/ProductInformation/{bookid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookInCart(@PathParam("bookid") String id) {

		BookDAO book_dao = new BookDAO();
		Book book = book_dao.getBookById(id);
		System.out.println(book);
		return book;

	}

	/**
	 * Method to get list of all books in database book
	 * 
	 * @return List<Book>
	 */
	@GET
	@Path("/getAllBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBookList(){
		System.out.println("entered getallbooks service");
		BookDAO book_dao = new BookDAO();
		List<Book> book = book_dao.getAllBook();
		return book;
	}
}
