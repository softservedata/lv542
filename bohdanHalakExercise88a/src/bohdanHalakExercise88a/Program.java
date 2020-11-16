package bohdanHalakExercise88a;

import java.util.InputMismatchException;

import bohdanHalakExercise88a.service.Console;
import bohdanHalakExercise88a.service.DigitalException;
import bohdanHalakExercise88a.service.Verifier;

public class Program {
	public static void main(String[] args){
		int searchedDigit = 3;
		Console console = new Console();
		Verifier verifier = new Verifier();		
		int verifyingNumber = 0;
		
		console.printMessage("Enter natural number:");
		
		try {
			verifyingNumber = console.readInt();
			
			verifier.setSearchedDigit(searchedDigit);
			
			if ( verifier.containsDigit(verifyingNumber * verifyingNumber) ) {
				console.printMessage("Square of entered number contains " + searchedDigit);
			} else {
				console.printMessage("Square of entered number doesn't contain " + searchedDigit);
			}		
		}
		catch (InputMismatchException ex) {
			console.printMessage("Entered value isn't a natural number.");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			console.close();
		}
		
	}
}
