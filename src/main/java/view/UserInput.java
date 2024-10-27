package view;

import java.util.Scanner;
/**
 *
 * @author Radoslaw Szewczyk
 */
public class UserInput 
{
    static String getUserInputFromConsole()
    { 
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
    
    public static String chooseArgumentsDuringRuntime()
    {
        System.out.print("No arguments given, choose now");
        System.out.print("Type denominations:");
        String denominations = getUserInputFromConsole();
        System.out.print("Type change:");
        String change = getUserInputFromConsole();
        return "-n " + denominations + " -c " + change;
    }
}
