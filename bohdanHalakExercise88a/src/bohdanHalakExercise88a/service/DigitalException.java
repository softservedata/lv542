package bohdanHalakExercise88a.service;

public class DigitalException extends RuntimeException {
	private int number = 0;
	
	public int getNumber() {
		return number;
	}
	
	public DigitalException(String message, int number) {
		super(message);
		this.number = number;
	}
}
