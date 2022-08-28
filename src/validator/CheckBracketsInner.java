package validator;

import data.StorageBrackets;
import data.StorageBracketsInner;
import enteties.Chars;
import enteties.StatusBrackets;

/**
 * @author Sergey Klunniy
 */
public class CheckBracketsInner {
    public static void isValidStringCheckBrackets(String str) {
        char[] chars = str.toCharArray();

        for (int index = 0; index < chars.length; index++) {
            if (chars[index] == Chars.OPEN_BRACKET.getValue()) {
                StorageBracketsInner.addBrackets(index, StatusBrackets.OPEN);
            }

            //проверил что закрывающая скобка идет после открывающей
            if (chars[index] == Chars.CLOSED_BRACKET.getValue()) {
                StorageBracketsInner.addBrackets(index, StatusBrackets.CLOSED);
            }
        }
    }
}
