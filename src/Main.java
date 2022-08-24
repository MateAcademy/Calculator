
import handler.ConsoleHandler;
import servce.Сalculator;
import validator.CheckBrackets;
import validator.CheckStringMatches;

/**
 * @author Sergey Klunniy
 */
public class Main {

    public static void main(String[] args) {
       /* >history
        03.05.2001
        5*(8-3)-(6+7)-(=error
        05.02.2021
        8*(9+9*(9+8))=1296
        05.06.2020
        8*(7-(6+8))=-56

        String str = "88*(9+9*(9+8))
        */

        String stringToCalculate = ConsoleHandler.consoleHandler();

        boolean isValidStringToCalculateMatches = CheckStringMatches.isValidStringToCalculate(stringToCalculate);
        if (!isValidStringToCalculateMatches)
            return;

        boolean isValidStringCheckBrackets = CheckBrackets.isValidStringCheckBrackets(stringToCalculate);
        if (!isValidStringCheckBrackets)
            return;

        Сalculator.calculate(stringToCalculate);
    }
}



