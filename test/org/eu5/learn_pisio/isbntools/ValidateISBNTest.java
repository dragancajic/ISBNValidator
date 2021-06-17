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
	public void checkAValid13DigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9788678925924");
		assertTrue("first 13-digit value", result);
		
		result = validator.checkISBN("9789995546021");
		assertTrue("second 13-digit value", result);
	}
	
	@Test
	public void ISBNsIncludingXAreValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void checkAnInvalidISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		//fail();
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void nineDigitISBNsAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("123456789");
	}
	
	// check that "helloworld" gives a NumberFormatException
	@Test(expected = NumberFormatException.class)
	public void nonNumericISBNsAreNotAllowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("helloworld");
	}

}
