package org.eu5.learn_pisio.isbntools;

public class StockManager {

	private ExternalISBNDataService webService;
	private ExternalISBNDataService databaseService;
	
	public void setWebService(ExternalISBNDataService webService) {
		this.webService = webService;
	}
	
	public void setDatabaseService(ExternalISBNDataService databaseService) {
		this.databaseService = databaseService;
	}
	
	public String getLocatorCode(String isbn) {
		// try to get a book from the database first
		Book book = databaseService.lookup(isbn);
		
		// if it's null try again from the web service
		if (book == null) {
			book = webService.lookup(isbn);
		}
		
		StringBuilder locator = new StringBuilder();
		locator.append(isbn.substring(isbn.length() - 4));
		locator.append(book.getAuthor(), 0, 1);
		locator.append(book.getTitle().split(" ").length);
		
		return locator.toString();
	}
}
