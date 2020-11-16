package bohdanHalakExercise88b.service;

public class Reverser {
	public boolean isNatural(int num) {
		if(num > 0) {
			return true;
		}
		
		return false;
	}
	
	public int reversNumber(int number) {
		if ( !isNatural(number) ) {
			throw new NaturalNumberException("Entered number isn't natural.", number);
		}
		
		String input = Integer.toString(number);
	    StringBuilder output = new StringBuilder();
	    
	    output.append(input);
	    output = output.reverse();
	    
	    return Integer.parseInt ( output.toString() );
	}
}
