import count.Calculator;
import count.NoCorrectMathOperationException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sergey Klunniy
 */
public class CalculatorTest {

    @Test
    public void testSum() {
        Double rez = Calculator.count('+', 2.0, 3.0);
        Double actualResult = 5.0;
        Assert.assertEquals(rez, actualResult);
    }

    @Test
    public void testMultiplication() {
        Double rez = Calculator.count('*', 2.0, 2.0);
        Double actualResult = 4.0;
        Assert.assertEquals(rez, actualResult);
    }

    @Test
    public void testMinus() {
        Double rez = Calculator.count('-', 2.0, 2.0);
        Double actualResult = 0.0;
        Assert.assertEquals(rez, actualResult);
    }

    @Test
    public void testDivision() {
        Double rez = Calculator.count('/', 8.0, 4.0);
        Double actualResult = 2.0;
        Assert.assertEquals(rez, actualResult);
    }

    @Test(expected = NoCorrectMathOperationException.class)
    public void testNoCorrectMathOperation() {
        Calculator.count('$', 2.0, 2.0);
    }

    @Test(expected = NullPointerException.class)
    public void testActWithNull() {
        Calculator.count('-', null, 2.0);
    }

    @Test()
    public void testPower() {
        Double rez = Calculator.count('^', 3.0, 2.0);
        Double actualResult = 9.0;
        Assert.assertEquals(rez, actualResult);
    }

    @Test()
    public void testNegativeDegree() {
        Double rez = Calculator.count('^', 3.0, -2.0);
        Double actualResult = 0.1111111111111111;
        Assert.assertEquals(rez, actualResult);
    }

    @Test
    public void testSubtractionNegativeNumber() {
        Double rez = Calculator.count('-', 2.0, -2.0);
        Double actualResult = 4.0;
        Assert.assertEquals(rez, actualResult);
    }
}
