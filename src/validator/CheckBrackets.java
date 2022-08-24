package validator;

import enteties.Chars;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Klunniy
 */
public class CheckBrackets {

    private static double rezult;
    private static List<Integer> pozitionOpenBrackets = new ArrayList<>();
    private static List<Integer> pozitionClozedBrackets = new ArrayList<>();

    public static boolean isValidStringCheckBrackets(String str) {
        char[] chars = str.toCharArray();
        int open = 0;
        int closed = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == Chars.OPEN_BRACKET.getValue()) {
                open++;
                pozitionOpenBrackets.add(i);
            }

            if (chars[i] == Chars.CLOSED_BRACKET.getValue()) {
                closed++;
                pozitionClozedBrackets.add(i);
            }
        }

        if (!(open == closed)) {
            System.out.println(str + "=error");
            return false;
        }
        return true;
    }

}
