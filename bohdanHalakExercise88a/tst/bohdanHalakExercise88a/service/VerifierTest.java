package bohdanHalakExercise88a.service;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifierTest {
	private static Verifier verifier = null;
	
  @BeforeClass
  public void beforeClass() {
		verifier = new Verifier();
		verifier.setSearchedDigit(3);
  }

  @DataProvider(name = "digitToCharDataProviderPositivValues")
  public Object[][] dataProviderMethodPositiveValues() {
      return new Object[][] {
    	  {'5', 5},
    	  {'0', 0},
    	  {'9', 9}
      };
  }
  
  
  @Test(dataProvider = "digitToCharDataProviderPositivValues")
  public void digitToCharPositiveTestWithPositiveDigit(char digitalChar, int digit) {
	  char expected = digitalChar;
	  char actual = verifier.digitToChar(digit);
	  
	  Assert.assertEquals(expected, actual);
  }
  
  @DataProvider(name = "digitToCharDataProviderNegativeValues")
  public Object[][] digitToCharDataProviderMethodNegativeValues() {
      return new Object[][] {
    	  {-5},
    	  {-1},
    	  {10},
    	  {33}
      };
  }
  
  @Test(expectedExceptions = DigitalException.class, dataProvider =  "digitToCharDataProviderNegativeValues")
  public void digitToCharNegativeTestWithNegativeDigit(int number) {
	  verifier.digitToChar(number);
  }
  
  
  @DataProvider(name = "hasDigitDataProviderPositiveValues")
  public Object[][] hasDigitDataProviderMethodPositiveValues() {
      return new Object[][] {
    	  {true, 324},
    	  {false, 28}
      };
  }
  
  
  
  @Test(dataProvider = "hasDigitDataProviderPositiveValues")
  public void hasDigitPositiveTest(boolean expected, long num) {
		boolean actual = verifier.containsDigit(num);
		
		Assert.assertEquals(expected, actual);
  }
  
  
  @DataProvider(name = "hasDigitDataProviderNegativeValues")
  public Object[][] hasDigitdDataProviderMethodNegativeValues() {
      return new Object[][] {
    	  {-7},
    	  {0}
      };
  }
  
  @Test(expectedExceptions = NaturalNumberException.class, dataProvider =  "hasDigitDataProviderNegativeValues")
  public void hasDigitNegativeTest(long num) {	  	
		boolean actual = verifier.containsDigit(num);
  }
  
  
  @DataProvider(name = "setSearchedDigitDataProviderNegativeValues")
  public Object[][] setSearchedDigitDataProviderMethodNegativeValues() {
      return new Object[][] {
    	  {-9},
    	  {11}
      };
  }
  
  @Test(expectedExceptions = DigitalException.class, dataProvider = "setSearchedDigitDataProviderNegativeValues")
  public void setSearchedDigitNegativeTestWithNegativeValue(int num) {
	  verifier.setSearchedDigit(num);
  }
  
  @DataProvider(name = "isDigitDataProviderPositiveValues")
  public Object[][] isDigitDataProviderMethodPositiveValues() {
      return new Object[][] {
    	  {false, -9},
    	  {false, 11},
    	  {true, 7}
      };
  }
  
  @Test(dataProvider = "isDigitDataProviderPositiveValues")
  public void isDigitPositiveTest(boolean expected, int num) {
	  boolean actual = verifier.isDigit(num);
	  
	  Assert.assertEquals(expected, actual);
  }
}