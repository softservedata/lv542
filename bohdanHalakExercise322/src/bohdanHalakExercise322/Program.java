package bohdanHalakExercise322;

import bohdanHalakExercise322.service.Calc;
import bohdanHalakExercise322.service.Console;

public class Program {

	public static void main(String[] args) {
		final int startInterval =  20;
		final int endInterval = 1;
		int maxDividersNum = 0;
		Calc calc = new Calc();
		Console console = new Console();
		
		try {
			maxDividersNum = calc.getMaxDividersNum(startInterval, endInterval);
			
			console.printMessage("Number in the interval from " + startInterval + " to " + endInterval +
					"\nwith max sum of dividers is " + maxDividersNum);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			console.close();
		}
		
	}

}
