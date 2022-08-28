package validator;

import data.StorageBrackets;
import enteties.Chars;
import enteties.StatusBrackets;

/**
 * @author Sergey Klunniy
 */
public class CheckBrackets {

    public static boolean isValidStringCheckBrackets(String str) {
        char[] chars = str.toCharArray();
        int open = 0;
        int closed = 0;

        for (int index = 0; index < chars.length; index++) {

            if (chars[index] == Chars.OPEN_BRACKET.getValue()) {
                open++;
                StorageBrackets.positionOpenBrackets.add(index);
                StorageBrackets.addBrackets(index, StatusBrackets.OPEN);
            }

            //проверил что закрывающая скобка идет после открывающей
            if (chars[index] == Chars.CLOSED_BRACKET.getValue() && (StorageBrackets.positionClosedBrackets.size() < StorageBrackets.positionOpenBrackets.size())) {
                closed++;
                StorageBrackets.positionClosedBrackets.add(index);
                StorageBrackets.addBrackets(index, StatusBrackets.CLOSED);
            }
        }

        if (!(open == closed)) {
            System.out.println(str + "=error");
            return false;
        }
        return true;
    }

}
