import count.Calculator;
import count.NoCorrectMathOperationException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sergey Klunniy
 */
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testSum() {
        Double actualResult = calculator.count('+', 2.0, 3.0);
        Double expectedResult  = 5.0;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMultiplication() {
        Double actualResult = calculator.count('*', 2.0, 2.0);
        Double expectedResult = 4.0;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMinus() {
        Double actualResult = calculator.count('-', 2.0, 2.0);
        Double expectedResult = 0.0;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDivision() {
        Double actualResult = calculator.count('/', 8.0, 4.0);
        Double expectedResult = 2.0;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NoCorrectMathOperationException.class)
    public void testNoCorrectMathOperation() {
        calculator.count('$', 2.0, 2.0);
    }

    @Test(expected = NullPointerException.class)
    public void testActWithNull() {
        calculator.count('-', null, 2.0);
    }

    @Test
    public void testPower() {
        Double actualResult = calculator.count('^', 3.0, 2.0);
        Double expectedResult = 9.0;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNegativeDegree() {
        Double actualResult = calculator.count('^', 3.0, -2.0);
        Double expectedResult = 0.1111111111111111;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSubtractionNegativeNumber() {
        Double actualResult = calculator.count('-', 2.0, -2.0);
        Double expectedResult = 4.0;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDivisionByZero() {
        Double actualResult = calculator.count('/', 2.0, 0.0);
        Double expectedResult = Double.POSITIVE_INFINITY;
        Assert.assertEquals(expectedResult, actualResult);
    }
}
