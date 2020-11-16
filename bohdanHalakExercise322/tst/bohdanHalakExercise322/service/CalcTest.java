package bohdanHalakExercise322.service;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class CalcTest {
	private static Calc calc = null;

	@BeforeClass
	public void beforeClass() {
		calc = new Calc();
	}

	@BeforeMethod
	public void beforeMethod() {
		calc.numerics.clear();
	}

	@DataProvider(name = "getMaxDividersNumDataProviderPositiveValues")
	public Object[][] getMaxDividersNumDataProviderMethodPositiveValues() {
		return new Object[][] {
			{ 9240, 9240, 10_000 },
			{ 8820, 961, 9239 },
			{ 960, 1, 960 },
			{ 20, 20, 1 },
			{ 20, 20, 20 } 
		};
	}

	@Test(dataProvider = "getMaxDividersNumDataProviderPositiveValues")
	public void getMaxDividersNumPositiveTest(int result, int start, int end) {
		int expected = result;
		int actual = calc.getMaxDividersNum(start, end);

		Assert.assertEquals(expected, actual);
	}

	@DataProvider(name = "getMaxDividersNumDataProviderNegativeValues")
	public Object[][] getMaxDividersNumDataProviderMethodNegativeValues() {
		return new Object[][] { 
			{ -5, -6 },
			{ -100, 0 },
			{ -234, 16 },
			{ 0, -1 },
			{ 0, 0 },
			{ 0, 23 },
			{ 17, -3 },
			{ 1, 0 }
		};
	}

	@Test(expectedExceptions = NaturalNumberException.class, dataProvider = "getMaxDividersNumDataProviderNegativeValues")
	public void getMaxDividersNumNegativeTestWithZeroStartIntervalPositiveEndInterval(int start, int end) {
		calc.getMaxDividersNum(start, end);
	}
	
	@DataProvider(name = "isNaturalDataProviderPositiveValues")
	public Object[][] isNaturalDataProviderMethodPositiveValues() {
		return new Object[][] {
			{ true, 3454 },
			{ false, 0 },
			{ false, -99 }
		};
	}
	
	@Test(dataProvider = "isNaturalDataProviderPositiveValues")
	public void isNaturalPositiveTestWithNaturalNumber(boolean result, int num) {
		boolean expected = result;
		boolean actual = calc.isNatural(num);

		Assert.assertEquals(expected, actual);
	}
}
