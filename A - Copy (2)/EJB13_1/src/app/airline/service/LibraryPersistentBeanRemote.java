package app.airline.service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibraryPersistentBeanRemote {
	void addBook(Book bookName);

	List<Book> getBooks();
}
