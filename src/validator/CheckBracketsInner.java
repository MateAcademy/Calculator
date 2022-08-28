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
        int open = 0;
        int closed = 0;

        for (int index = 0; index < chars.length; index++) {
            if (chars[index] == Chars.OPEN_BRACKET.getValue()) {
                open++;
                StorageBracketsInner.positionOpenBrackets.add(index);
                StorageBracketsInner.addBrackets(index, StatusBrackets.OPEN);
            }

            //проверил что закрывающая скобка идет после открывающей
            if (chars[index] == Chars.CLOSED_BRACKET.getValue() && (StorageBracketsInner.positionClosedBrackets.size() < StorageBracketsInner.positionOpenBrackets.size())) {
                closed++;
                StorageBracketsInner.positionClosedBrackets.add(index);
                StorageBracketsInner.addBrackets(index, StatusBrackets.CLOSED);
            }
        }
    }
}
