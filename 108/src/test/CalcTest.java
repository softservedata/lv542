package test;
import com.company.Calc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


public class CalcTest {
    private static Calc calc = null;
    @BeforeClass
    public static void setUpBeforeClass() {
        calc = new Calc();
    }
    @DataProvider(name="Calculating")
    public Object[][] GetData(){
        Object[][] data={
                {8,4},
                {4,3},
        };
        return data;
    }
    @Test(dataProvider = "Calculating")
    public void CalculatingTest(int expected,int origin) {
        Assert.assertEquals(expected,calc.calculate(origin));
    }


}