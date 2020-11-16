package bohdanHalakExercise88b;


import java.util.InputMismatchException;

import bohdanHalakExercise88b.service.Console;
import bohdanHalakExercise88b.service.Reverser;

public class Program {

	public static void main(String[] args) {
		Console console = new Console();
		Reverser reverser = new Reverser();
		int result = 0;
		int enteredNumber = 0;
		console.printMessage("Enter natural number:");

		
		try {
			enteredNumber = console.readInt();
			
			result = reverser.reversNumber(enteredNumber);
			
			console.printMessage("Reverse number is " + result);
		}
		catch (InputMismatchException ex) {
			console.printMessage("Entered value isn't a natural number.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			console.close();
		}				  
	}

}
