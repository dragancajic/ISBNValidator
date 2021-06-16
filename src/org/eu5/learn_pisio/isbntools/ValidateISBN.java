package org.eu5.learn_pisio.isbntools;

public class ValidateISBN {
	
	public boolean checkISBN(String isbn) {
		// start implementing business logic
		
		if (isbn.length() != 10) {
			throw new NumberFormatException("ISBN numbers must be 10 digits long!");
		}
		/*
		// can't have non-numeric characters
		boolean hasNonNumeric = true;
		
		for (int i = 0; i < 10; i++) {
			char digit = isbn.charAt(i);
			
			if (digit >= 48 && digit <= 57) { // ASCII 48-57 [0-9]
				hasNonNumeric = false;
			}
		}
		
		if (hasNonNumeric) {
			throw new NumberFormatException("ISBNs can only contain numeric characters!");
		}
		*/
		int total = 0;
		
		for (int i = 0; i < 10; i++) {
			char digit = isbn.charAt(i);
			
			if (!Character.isDigit(digit)) {
				if (i == 9 && digit == 'X') {
					// this is OK!
				} else {
					throw new NumberFormatException("ISBNs can only contain numeric characters!");
				}
			}
			
			total = digit * (10 - i);
		}
		
		if (total % 11 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
