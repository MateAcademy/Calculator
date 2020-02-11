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
        Assert.assertEquals(rez, (Object) 5.0);
    }

    @Test
    public void testMultiplication() {
        Double rez = Calculator.count('*', 2.0, 2.0);
        Assert.assertEquals(rez, (Object) 4.0);
    }

    @Test
    public void testMinus() {
        Double rez = Calculator.count('-', 2.0, 2.0);
        Assert.assertEquals(rez, (Object) 0.0);
    }

    @Test
    public void testDivision() {
        Double rez = Calculator.count('/', 8.0, 4.0);
        Assert.assertEquals(rez, (Object) 2.0);
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
        Assert.assertEquals(rez, (Object) 9.0);
    }

    @Test()
    public void testNegativeDegree() {
        Double rez = Calculator.count('^', 3.0, -2.0);
        Assert.assertEquals(rez, (Object) 0.1111111111111111);
    }

    @Test
    public void testSubtractionNegativeNumber() {
        Double rez = Calculator.count('-', 2.0, -2.0);
        Assert.assertEquals(rez, (Object) 4.0);
    }
}
