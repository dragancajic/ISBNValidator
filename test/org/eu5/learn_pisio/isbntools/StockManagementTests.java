package org.eu5.learn_pisio.isbntools;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StockManagementTests {

	@Before
	public void setup() {
	
	}
	
	@Test
	public void testCanGetACorrectLocatorCode() {
		
		// database
		ExternalISBNDataService testDatabaseService = new ExternalISBNDataService() {
			@Override
			public Book lookup(String isbn) {
				return null;
			}
		};
		
		// webservice
		ExternalISBNDataService testWebService = new ExternalISBNDataService() {
			@Override
			public Book lookup(String isbn) {
				return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
			}
		};
		
		StockManager stockManager = new StockManager();
		stockManager.setDatabaseService(testDatabaseService);
		stockManager.setWebService(testWebService);
		
		String isbn = "0140177396";
		String locatorCode = stockManager.getLocatorCode(isbn);
		assertEquals("7396J4", locatorCode);
	}
	
	@Test
	public void databaseIsUsedIfDataIsPresent() {
		fail();
	}
	
	@Test
	public void webServiceIsUsedIfDataIsNotPresentInDatabase() {
		fail();
	}
}
