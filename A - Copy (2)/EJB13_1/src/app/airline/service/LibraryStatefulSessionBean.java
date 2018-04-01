package app.airline.service;

import java.util.List;

import javax.ejb.Stateful;

@Stateful
public class LibraryStatefulSessionBean implements LibraryPersistentBeanRemote {

	@Override
	public void addBook(Book bookName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return null;
	}
	
   //implement business method 
}