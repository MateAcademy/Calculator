package servce;

import enteties.Chars;
import java.util.Stack;

/**
 * @author Sergey Klunniy
 */
public class Сalculator {

    public static void calculate(String str) {
        // "88*(9+9*(9+8)+1)";
        char[] chars = str.toCharArray();
        calculate(chars);
    }

    private static void calculate(char[] chars) {
        Stack<String> numbers = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= Chars.NUMBER_BOTTOM_LIMIT.getValue() && chars[i] <= Chars.NUMBER_TOP_LIMIT.getValue()) {
                StringBuilder numberBuilder = new StringBuilder().append(chars[i++]);
                for (; i < chars.length; i++) {
                    if (chars[i] > Chars.NUMBER_TOP_LIMIT.getValue() || chars[i] < Chars.NUMBER_BOTTOM_LIMIT.getValue()) {
                        break;
                    }
                    numberBuilder.append(chars[i]);
                }
                numbers.add(numberBuilder.toString());

            }
        }
        System.out.println(numbers);
    }

}



