import count.Calculator;
import count.MyException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sergey Klunniy
 */
public class CalculatorTest {

    @Test
    public void test1() {
        Integer rez  = Calculator.count('+', 2, 3);
        Assert.assertEquals(rez, (Integer) 5);
    }

    @Test
    public void test2() {
        Integer rez  = Calculator.count('*', 2, 2);
        Assert.assertEquals(rez, (Integer) 4);
    }

    @Test
    public void test3() {
        Integer rez  = Calculator.count('-', 2, 2);
        Assert.assertEquals(rez, (Integer) 0);
    }

    @Test
    public void test4() {
        Integer rez  = Calculator.count('/', 8, 4);
        Assert.assertEquals(rez, (Integer) 2);
    }

    @Test(expected = MyException.class)
    public void test5() {
        Integer rez  = Calculator.count('$', 2, 2);
    }

    @Test(expected = NullPointerException.class)
    public void test6() {
        Integer rez  = Calculator.count('-', null, 2);
    }
}
