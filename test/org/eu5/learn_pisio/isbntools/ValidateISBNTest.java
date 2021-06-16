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
		boolean result = validator.checkISBN(140449116);
		assertTrue(result);
	}
	
	@Test
	public void checkAnIvalidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN(140449117);
		//fail();
		assertFalse(result);
	}

}
