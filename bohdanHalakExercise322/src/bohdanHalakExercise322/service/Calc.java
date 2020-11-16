package bohdanHalakExercise322.service;

import java.util.ArrayList;
import java.util.List;


public class Calc {
	public List<Numeric> numerics = null;
	
	public Calc() {
		numerics = new ArrayList<Numeric>();
	}
	
	public int getMaxDividersNum(int startInterval, int endInterval) {
		if( !isNatural(startInterval) || !isNatural(endInterval) ) {
			throw new NaturalNumberException("One of the intervals isn't natural value.");
		}
		
		if(startInterval > endInterval) {
			int tmp = startInterval;
			startInterval = endInterval;
			endInterval = tmp;
		}
		
		int index = 0;
		for (int numeric = startInterval; numeric <= endInterval; numeric++ ) {
			numerics.add( new Numeric(numeric) );
			
			for (int j = 1; j <= numeric; j++) {
				if (numerics.get(index).numeric % j == 0) {
					numerics.get(index).dividers.add(j);
				}
			}
			
			numerics.get(index).countDividersSum();
			index++;
		}
		
		numerics.sort(new NumericComparator());
		
		return numerics.get(0).numeric;
	}
	
	public boolean isNatural(int num){
		if (num > 0) {
			return true;
		}
		
		return false;		
	}
}
