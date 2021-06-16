package org.eu5.learn_pisio.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	/*
	@Test
	public void test() {
		//fail("Not yet implemented");
		//fail("This test needs to fail!");
	}
	*/
	
	//int a = 2_100_000_006; // check range for integer
	
	@Test
	public void checkAValidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertTrue("first value", result);
		
		// second example of valid ISBN number
		// YES! We can put it in the same test method!
		// It's the same logic that we are testing! :0)
		result = validator.checkISBN("0140489157");
		assertTrue("second value", result);
	}
	
	@Test
	public void checkAnInvalidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		//fail();
		assertFalse(result);
	}

}
