package count;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author Sergey Klunniy
 */
public class Calculator {

    private static HashMap<Character, Count> calculator = new HashMap<>();

     static {
        Count sum = (a, b) -> a + b;
        calculator.put('+', sum);
        Count sum2 = (a, b) -> a - b;
        calculator.put('-', sum2);
        Count multiply = (a, b) -> a * b;
        calculator.put('*', multiply);
        Count divizion = (a, b) -> a / b;
        calculator.put('/', divizion);
        Count power = (a, b) -> Math.pow(a , b);
        calculator.put('^', power);
    }

    public static Double count(Character operation, Double b, Double c) {
        Optional<Count> rezult = Optional.ofNullable(calculator.get(operation));
        return rezult.orElseThrow(NoCorrectMathOperationException::new).run(b, c);
    }
}
