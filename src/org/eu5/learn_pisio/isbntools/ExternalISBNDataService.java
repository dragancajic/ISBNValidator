package org.eu5.learn_pisio.isbntools;

public class ExternalISBNDataService {
	
	public Book lookup(String isbn) {
		return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
	}
}
