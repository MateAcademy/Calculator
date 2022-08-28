
import handler.ConsoleHandler;
import servce.Сalculator;




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

//      String stringToCalculate = "5*(8-3)-(6+7)";     // = 12;
        String stringToCalculate = "50+(4+(8*1)+(4+1))*2+1";
//        String stringToCalculate =   "50+(4+1)*(2+6)";   //90
//        String stringToCalculate =   "((50+(4+1)+(4+1)))";  //60

                             // String stringToCalculate = "((50+((4+1)*(2+6))))";

//        String stringToCalculate = "(50+(4+1)*(2+6))";
//        String stringToCalculate = "((50+(4+1)+(5)))";
//        String stringToCalculate = "((50+(4+1)+(5)))";

        String rez = Сalculator.countUp(stringToCalculate);
        System.out.println(rez);
    }

}



