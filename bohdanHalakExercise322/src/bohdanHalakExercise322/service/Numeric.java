package bohdanHalakExercise322.service;

import java.util.ArrayList;
import java.util.List;

public class Numeric {
	public int numeric = 0;
	public List<Integer> dividers = null;
	public int sum = 0;
	
	public Numeric(int numeric) {
		this.numeric = numeric;
		dividers = new ArrayList<Integer>();
	}
	
	public int countDividersSum() {		
		for (int i = 0; i < dividers.size(); i++) {
			sum += dividers.get(i);
		}
		return sum;
	}
}
