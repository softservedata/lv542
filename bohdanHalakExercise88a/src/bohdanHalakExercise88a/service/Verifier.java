package bohdanHalakExercise88a.service;

public class Verifier {
	private int searchedDigit = 0;
	
	public int getSearcheDigit() {
		return searchedDigit;
	}
	
	public void setSearchedDigit(int digit) {
		
		if ( isDigit(digit) ) {
			this.searchedDigit = digit;
		}
		else {
			throw new DigitalException("Incorect entered data.\nDigit is number from 0 to 9.", digit);
		}
	}
	
	public boolean containsDigit(long num) {
		if (num <= 0) {
			throw new NaturalNumberException("Num should be natural.");
		}
		boolean containsChar = false;
		char searchedChar = digitToChar(searchedDigit);
		String strNumber = Long.toString(num);
		
		for (int i = 0; i < strNumber.length(); i++) {
			if (strNumber.charAt(i) == searchedChar) {
				containsChar = true;
				break;
			}
		}
		
		return containsChar;
	}
	
	public char digitToChar(int num){
		if ( isDigit(num) ) {
			return (char)(48 + num);
		}
		else {
			throw new DigitalException("Incorect entered data.\nDigit is number from 0 to 9.", num);
		}
	}
	
	public boolean isDigit(int num) {
		if (num < 0 || num > 9) {
			return false;
		}
		
		return true;
	}
}
