package handler;

import java.util.Scanner;

/**
 * @author Sergey Klunniy
 */
public class ConsoleHandler {

    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string for the calculator:");
        System.out.print("string = ");
        String str = scanner.nextLine();
        scanner.close();
        return str;
    }

}
