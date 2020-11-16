package bohdanHalakExercise322.service;

import java.util.Scanner;

public class Console {
	private Scanner scanner;
	
	{
		scanner = new Scanner(System.in);
	}
	
	public int readInt()  throws NaturalNumberException {
		int num = 0;
		if( scanner.hasNextInt()) {
			num = scanner.nextInt();
			if (isNatural(num)) {
				return num;
			}
			else {
				throw new NaturalNumberException("Entered number isn't natural.", num);
			}
		} else if (scanner.hasNextLong()) {
			throw new NaturalNumberException("Entered number is too big.", num);
		} else {
			throw new NaturalNumberException("You have entered invalid data.", num);
		}
		
	}
	
	public void printMessage(String message) {
		System.out.print(message);
	}
	
	public void close() {
		try {
			scanner.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean isNatural(int num){
		if (num > 0) {
			return true;
		}
		
		return false;		
	}
	 
}
