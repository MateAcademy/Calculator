package handler;

import java.util.Scanner;

/**
 * @author Sergey Klunniy
 */
public class ConsoleHandler {

    public static String consoleHandler() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string for the calculator:");
        System.out.print("string = ");
        String str = scanner.next();
        scanner.close();
        return str;
    }

}
