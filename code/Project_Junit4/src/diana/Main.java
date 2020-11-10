package diana;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import diana.classes.CalcIntNumbers;
import diana.classes.Console;
import diana.classes.PythagoreanTriple;

public class Main {

	public static void main(String[] args) {
		Console con = new Console();
		CalcIntNumbers calc = new CalcIntNumbers();
		List<Integer> array = new ArrayList<>();
		int resB;
		int resV;
		Set<PythagoreanTriple> list = new HashSet<>();
		
		con.fillArr(array, con.readNaturalNum("N= ", 0));
		resB = calc.findNumbers(array);
		resV = calc.findSquareNumbers(array);
		
		con.write("Amount of numbers multiple of 3 and non-multiple of 5: ", resB);
		con.write("Amount of square numbers: ", resV);
		
		list = calc.findTriples(con.readNaturalNum("N= ", 0));		
		for (PythagoreanTriple t : list) {
			con.write(t);
		}

	}
}
