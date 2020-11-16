package bohdanHalakExercise322.service;

import java.util.Comparator;

public class NumericComparator implements Comparator<Numeric>{
	public int compare(Numeric a, Numeric b) {
		return  b.sum - a.sum;
	}
}
