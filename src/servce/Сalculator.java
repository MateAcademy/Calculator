package servce;

//import data.StorageBrackets;
//import data.StorageBracketsInner;
//import enteties.Brackets;
//import enteties.Chars;
//import enteties.Operations;
//import validator.CheckBrackets;
//import validator.CheckBracketsInner;

import data.StorageBrackets;
import data.StorageBracketsInner;
import enteties.Brackets;
import enteties.Chars;
import enteties.Operations;
import validator.CheckBracketsInner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static validator.CheckBrackets.isValidStringCheckBrackets;
import static validator.CheckStringMatches.isValidStringToCalculate;

//import static validator.CheckBrackets.isValidStringCheckBrackets;
//import static validator.CheckStringMatches.isValidStringToCalculate;

/**
 * @author Sergey Klunniy
 */
public class Сalculator {
    public static String myValidString;
    public int constanta = 0;

    static int amountBrackets = StorageBrackets.positionClosedBrackets.size();  //2

    public static String countUp(String stringToCalculate) {

        stringToCalculate = stringToCalculate.replaceAll("[\\s]+", "");
        myValidString = stringToCalculate;

        if (!isValid(stringToCalculate)) {
            return stringToCalculate + "=error";
        }

        String rez = calculateParseAndValidString(myValidString);
        return rez;
    }

    private static boolean isValid(String stringToCalculate) {
        if (!isValidStringToCalculate(stringToCalculate)) {
            return false;
        }
        if (!isValidStringCheckBrackets(stringToCalculate)) {
            return false;
        }

        //сделать замну пробелов на ""
        return true;
    }

    private static char[] breakIntoCharactersString(String parsedAndValidatedString) {
        return parsedAndValidatedString.toCharArray();
    }


    private static String calculateParseAndValidString(String parsedAndValidatedString) {
        Сalculator c = new Сalculator();
        c.constanta = 0;
        char[] chars = breakIntoCharactersString(parsedAndValidatedString);

        List<String> numbers = new ArrayList<>();
        List<Operations> operations = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {

            //разбил строку parsedAndValidatedString на цифры и добавил их в numbers:
            if (chars[i] >= Chars.NUMBER_BOTTOM_LIMIT.getValue() && chars[i] <= Chars.NUMBER_TOP_LIMIT.getValue()) {
                StringBuilder numberBuilder = new StringBuilder().append(chars[i++]);
                for (; i < chars.length; i++) {
                    if (chars[i] < Chars.NUMBER_BOTTOM_LIMIT.getValue() || chars[i] > Chars.NUMBER_TOP_LIMIT.getValue()) {
                        break;
                    }
                    numberBuilder.append(chars[i]);
                }
                numbers.add(numberBuilder.toString());
                i--;
                continue;
            }

            //разбил строку parsedAndValidatedString на операции и добавил их в operations:
            if (chars[i] == Operations.ADDITION.getOperation()) {
                operations.add(Operations.ADDITION);
                continue;
            }

            if (chars[i] == Operations.SUBSTRACTION.getOperation()) {
                operations.add(Operations.SUBSTRACTION);
                continue;
            }

            if (chars[i] == Operations.MULTIPLY.getOperation()) {
                operations.add(Operations.MULTIPLY);
                continue;
            }

            if (chars[i] == Operations.DIVISION.getOperation()) {
                operations.add(Operations.DIVISION);
                continue;
            }

            //прохожусь по строке и если открытая скобка, то захожу в подстроку:
            if (chars[i] == Chars.OPEN_BRACKET.getValue()) {
                StorageBracketsInner.listBrackets = new ArrayList<>();
                //            String sb= parsedAndValidatedString.substring(i);
                CheckBracketsInner.isValidStringCheckBrackets(parsedAndValidatedString);

                if (c.constanta != 0)
                    StorageBracketsInner.listBrackets.remove(0);

                c.constanta++;

                //if (i == 0) constanta++;
//                StorageBrackets.listBrackets = new ArrayList<>();
//                CheckBrackets.isValidStringCheckBrackets(parsedAndValidatedString);
//                AppConstant.count++;

                //я должен передать parsedAndValidateData.substring(bracketIndex + 1, closedBracket)
                Brackets brackets = StorageBrackets.listBrackets.get(0);
                StorageBrackets.listBrackets.remove(0);

                int openIndexInBrackets = brackets.getOpenPosition();
                int closedIndexInBrackets = brackets.getClosedPosition();

                String subStringToBrackets = myValidString.substring(openIndexInBrackets + 1, closedIndexInBrackets);

                Brackets bracketsInner = StorageBracketsInner.listBrackets.get(0);
                StorageBracketsInner.listBrackets.remove(0);
                i = bracketsInner.getClosedPosition();

                double rez = Double.parseDouble(calculateParseAndValidString(subStringToBrackets));
                numbers.add(Double.toString(rez));
            }
        }

        //реализовать проверку на откр скобки

        //прохожусь по операциям, сначала выполняю * и / потом остальные
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i) == Operations.MULTIPLY || operations.get(i) == Operations.DIVISION) {
                Double a = Double.parseDouble(numbers.get(i));
                Double b = Double.parseDouble(numbers.get(i + 1));
                Double rez;
                if (operations.get(i) == Operations.MULTIPLY) {
                    rez = Operations.MULTIPLY.count(a, b);
                } else {
                    rez = Operations.DIVISION.count(a, b);
                }

                numbers.set(i, rez.toString());
                numbers.remove(i + 1);
                operations.remove(i);
            }
        }

        for (int i = 0; i < operations.size(); ) {
            if (operations.get(i) == Operations.ADDITION || operations.get(i) == Operations.SUBSTRACTION) {
                Double a = Double.parseDouble(numbers.get(i));
                Double b = Double.parseDouble(numbers.get(i + 1));
                Double rez;
                if (operations.get(i) == Operations.ADDITION) {
                    rez = Operations.ADDITION.count(a, b);
                } else {
                    rez = Operations.SUBSTRACTION.count(a, b);
                }
                numbers.set(i, rez.toString());
                numbers.remove(i + 1);
                operations.remove(i);
            }
        }
        return numbers.get(0);
    }

}



