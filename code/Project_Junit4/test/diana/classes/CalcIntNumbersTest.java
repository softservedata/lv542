package diana.classes;

/*
 * Class to test CalcIntNumbersTest class
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcIntNumbersTest {

	private static CalcIntNumbers calc = null;

	@BeforeClass
	public static void setUpBeforeClass() {
		calc = new CalcIntNumbers();
	}

	@AfterClass
	public static void tearDownAfterClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}
	
	//1 task
	// 8 tests - EP + DT

	//square par + not square
	@Test
	public void PositiveTestFindSquareNumbersExistSomePN() {
		int actual;
		int expected;
		List<Integer> list = Arrays.asList(16, 4, 2, 8);
		
		expected = 2;
		actual = calc.findSquareNumbers(list);
		Assert.assertEquals(expected, actual);
	}
	
	//square not par
	@Test
	public void PositiveTestFindSquareNumbersExistSomeN() {
		int actual;
		int expected;
		List<Integer> list = Arrays.asList(25, 9, 49, 81);

		expected = 0;
		actual = calc.findSquareNumbers(list);
		Assert.assertEquals(expected, actual);
	}
	
	//square not par + square par
	@Test
	public void PositiveTestFindSquareNumbersExistSomeNP() {
		int actual;
		int expected;
		List<Integer> a = Arrays.asList(16, 9, 25, 64);

		expected = 2;
		actual = calc.findSquareNumbers(a);
		Assert.assertEquals(expected, actual);
	}
		
	//square not par + not square
	@Test
	public void PositiveTestFindSquareNumbersExistSomeNN() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();
		a.add(8);
		a.add(9);
		a.add(3);
		a.add(81);

		expected = 0;
		actual = calc.findSquareNumbers(a);
		Assert.assertEquals(expected, actual);
	}
	
	//square not par + not square + square par
	@Test
	public void PositiveTestFindSquareNumbersExistSomeNNP() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();
		a.add(8);
		a.add(9);
		a.add(3);
		a.add(16);

		expected = 1;
		actual = calc.findSquareNumbers(a);
		Assert.assertEquals(expected, actual);
	}

	//square par
	@Test
	public void PositiveTestFindSquareNumbersExistAll() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();
		a.add(16);
		a.add(4);
		a.add(100);
		a.add(36);

		expected = 4;
		actual = calc.findSquareNumbers(a);
		Assert.assertEquals(expected, actual);
	}
	
	//not square
	@Test
	public void PositiveTestFindSquareNumbersNone1() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();
		a.add(7);
		a.add(3);
		a.add(2);
		a.add(8);

		expected = 0;
		actual = calc.findSquareNumbers(a);
		Assert.assertEquals(expected, actual);
	}

	//no elem
	@Test
	public void PositiveTestFindSquareNumbersEmpty2() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();

		expected = 0;
		actual = calc.findSquareNumbers(a);
		Assert.assertEquals(expected, actual);
	}

	// elem <0  //=0
	@Test(expected = RuntimeException.class)
	public void NegativeTestFindSquareNumbers() {
		List<Integer> a = new ArrayList<>();
		a.add(-7);
		a.add(3);
		a.add(2);
		a.add(8);

		calc.findSquareNumbers(a);
	}

	// 2 Task
	//16 tests - EP + DT

	//multiple by 3 not by 5
	@Test
	public void PositiveTestFindNumbersExistAll() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();
		a.add(9);
		a.add(3);
		a.add(6);
		a.add(12);

		expected = 4;
		actual = calc.findNumbers(a);
		Assert.assertEquals(expected, actual);
	}

	//multiple by 3 + by 5 + by 3 & 5 + not 3 & not 5
	@Test
	public void PositiveTestFindNumbersExistSome() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();
		a.add(16);
		a.add(3);
		a.add(100);
		a.add(36);

		expected = 2;
		actual = calc.findNumbers(a);
		Assert.assertEquals(expected, actual);
	}

	//multiple by 5 + not 3 & not 5
	@Test
	public void PositiveTestFindNumbersNone1() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();
		a.add(5);
		a.add(15);
		a.add(10);
		a.add(20);

		expected = 0;
		actual = calc.findNumbers(a);
		Assert.assertEquals(expected, actual);
	}

	//multiple + not 3 & not 5
	@Test
	public void PositiveTestFindNumbersNone2() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(4);

		expected = 0;
		actual = calc.findNumbers(a);
		Assert.assertEquals(expected, actual);
	}

	// no elements
	@Test
	public void PositiveTestFindNumbersEmpty() {
		int actual;
		int expected;
		List<Integer> a = new ArrayList<>();

		expected = 0;
		actual = calc.findNumbers(a);
		Assert.assertEquals(expected, actual);
	}
	
	//element =0
	@Test(expected = RuntimeException.class)
	public void NegativeTestFindeNumbersZero() {
		List<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(3);
		a.add(2);

		calc.findNumbers(a);
	}

	//element <0
	@Test(expected = RuntimeException.class)
	public void NegativeTestFindeNumbers() {
		List<Integer> a = new ArrayList<>();
		a.add(-7);
		a.add(3);
		a.add(2);

		calc.findNumbers(a);
	}

	//3 task
	//EP : -5, 0, 1, 5, 10, 15, 20	
	@Test(expected = RuntimeException.class)
	public void NegativeTestFindTriplesNegative() {
		calc.findTriples(-5);
	}
	
	@Test(expected = RuntimeException.class)
	public void NegativeTestFindTriplesZero() {
		calc.findTriples(0);
	}
	
	public void PositiveTestFindTriplesOne() {
		Set<PythagoreanTriple> actual;
		Set<PythagoreanTriple> expected;

		expected = new HashSet<PythagoreanTriple>();
		actual = calc.findTriples(1);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void PositiveTestFindTriplesFive() {
		Set<PythagoreanTriple> actual;
		Set<PythagoreanTriple> expected;

		expected = new HashSet<PythagoreanTriple>();
		expected.add(new PythagoreanTriple(3, 4, 5));
		actual = calc.findTriples(5);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void PositiveTestFindTriplesTen() {
		Set<PythagoreanTriple> actual;
		Set<PythagoreanTriple> expected;

		expected = new HashSet<PythagoreanTriple>();
		expected.add(new PythagoreanTriple(6, 8, 10));
		expected.add(new PythagoreanTriple(3, 4, 5));

		actual = calc.findTriples(10);
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void PositiveTestFindTriples15() {
		Set<PythagoreanTriple> actual;
		Set<PythagoreanTriple> expected;

		expected = new HashSet<PythagoreanTriple>();
		expected.add(new PythagoreanTriple(6, 8, 10));
		expected.add(new PythagoreanTriple(3, 4, 5));
		expected.add(new PythagoreanTriple(5, 12, 13));
		expected.add(new PythagoreanTriple(9, 12, 15));

		actual = calc.findTriples(15);
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void PositiveTestFindTriplesTwenty() {
		Set<PythagoreanTriple> actual;
		Set<PythagoreanTriple> expected;

		expected = new HashSet<PythagoreanTriple>();
		expected.add(new PythagoreanTriple(3, 4, 5));
		expected.add(new PythagoreanTriple(5, 12, 13));
		expected.add(new PythagoreanTriple(12, 16, 20));
		expected.add(new PythagoreanTriple(8, 15, 17));
		expected.add(new PythagoreanTriple(6, 8, 10));
		expected.add(new PythagoreanTriple(9, 12, 15));

		actual = calc.findTriples(20);
		Assert.assertEquals(expected, actual);

	}

}
