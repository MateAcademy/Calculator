package count;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author Sergey Klunniy
 */
public class Calculator {

    private static HashMap<Character, Count> calculator = new HashMap<>();

    private static void initializer() {
        Count sum = (a, b) -> a + b;
        calculator.put('+', sum);
        Count sum2 = (a, b) -> a - b;
        calculator.put('-', sum2);
        Count multiply = (a, b) -> a * b;
        calculator.put('*', multiply);
        Count divizion = (a, b) -> a / b;
        calculator.put('/', divizion);
    }

    public static Integer count(Character a, Integer b, Integer c) {
        initializer();
        Optional<Count> rez = Optional.ofNullable(calculator.get(a));
        return rez.orElseThrow(MyException::new).run(b, c);
    }

}
