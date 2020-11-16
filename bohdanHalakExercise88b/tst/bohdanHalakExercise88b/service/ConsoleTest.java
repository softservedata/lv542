package bohdanHalakExercise88b.service;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConsoleTest {
  private static Console console = null;
  
  @BeforeClass
  public void boforeClass() {
	  console = new Console();
  }
  
  @Test
  public void isNaturalPositiveTestWithNaturalValue() {
		boolean expected = true;
		boolean actual = console.isNatural(2);
		
		Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void isNaturalNegativeTestWithNegativelValue() {
		boolean expected = false;
		boolean actual = console.isNatural(-7);
		
		Assert.assertEquals(expected, actual);
  }
  
  @Test
  public void isNaturalNegativeTestWithZero() {
		boolean expected = false;
		boolean actual = console.isNatural(0);
		
		Assert.assertEquals(expected, actual);
  }

}
