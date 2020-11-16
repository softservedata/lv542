package bohdanHalakExercise88b.service;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class ReverserTest {
  Reverser reverser = null;
  @BeforeClass
  public void beforeClass() {
	  reverser = new Reverser();
  }

  @DataProvider(name = "isNaturalDataProviderPositiveValues")
  public Object[][] isNaturalDataProviderMethodPositiveValues() {
      return new Object[][] {
    	  {true, 5},
    	  {false, 0},
    	  {false, -19}
      };
  }
  
  @Test(dataProvider = "isNaturalDataProviderPositiveValues")
  public void isNaturalPositiveTest(boolean result, int num) {
		boolean expected = result;
		boolean actual = reverser.isNatural(num);
		
		Assert.assertEquals(expected, actual);
  }
 
  @DataProvider(name = "reversNumberDataProviderPositiveValues")
  public Object[][] reversNumberDataProviderMethodPositiveValues() {
      return new Object[][] {
    	  {1, 1},
    	  {34, 43},
    	  {1518, 8151}
      };
  }

  @Test(dataProvider = "reversNumberDataProviderPositiveValues")
  public void reversNumberPositiveTest(int reversedNum, int num) {
		int expected = reversedNum;
		int actual = reverser.reversNumber(num);
		
		Assert.assertEquals(expected, actual);
  }
  
  @DataProvider(name = "reversNumberDataProviderNegativeValues")
  public Object[][] reversNumberDataProviderMethodNegativeValues() {
      return new Object[][] {
    	  {0},
    	  {-17}
      };
  }
  
  @Test(expectedExceptions = NaturalNumberException.class, dataProvider = "reversNumberDataProviderNegativeValues")
  public void reversNumberPositiveTestWithTwoDigitsValue(int num) {
		int actual = reverser.reversNumber(num);
  }
}
