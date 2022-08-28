package validator;

/**
 * @author Sergey Klunniy
 */
public class CheckStringMatches {

    public static boolean isValidStringToCalculate(String str) {
        boolean check = str.matches("[\\d()*/+-]*");
        if (check == false) {
            System.out.println(str + "=error");
        }
        return true;
    }

}
