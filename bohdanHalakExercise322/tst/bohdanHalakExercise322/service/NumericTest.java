package bohdanHalakExercise322.service;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class NumericTest {
	private static Numeric numeric = null;

	@BeforeClass
	public void boforeClass() {
		int anyNum = 0;
		numeric = new Numeric(anyNum);
	}

	@BeforeMethod
	public void boforeMethod() {
		numeric.dividers.clear();
		numeric.sum = 0;
	}
	
	
	@DataProvider(name = "countDividersSumDataProviderPositiveValues")
	public Object[][] countDividersSumDataProviderMethodPositiveValues() {
		return new Object[][] {
			{ 9, Arrays.asList(new Integer[] { 9 } ) },
			{ 6, Arrays.asList(new Integer[] { 1, 5 } ) },
			{ 7, Arrays.asList(new Integer[] { 1, 2, 4 } ) }
		};
	}
	
	@Test(dataProvider = "countDividersSumDataProviderPositiveValues")
	public void countDividersSumPositiveTest(int sum, List<Integer> dividers) {
		numeric.dividers.addAll(dividers);

		int expected = sum;
		int actual = numeric.countDividersSum();

		Assert.assertEquals(expected, actual);
	}
}
