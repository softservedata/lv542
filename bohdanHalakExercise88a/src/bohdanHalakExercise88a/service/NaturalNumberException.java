package bohdanHalakExercise88a.service;

public class NaturalNumberException extends RuntimeException{
	private int number = 0;
	
	public int getNumber() {
		return number;
	}
	
	public NaturalNumberException(String message, int number) {
		super(message);
		this.number = number;
	}
	
	public NaturalNumberException(String message) {
		super(message);
	}
}
