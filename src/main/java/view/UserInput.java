package view;

import lombok.experimental.UtilityClass;
import java.util.Scanner;

/**
 *
 * @author Radoslaw Szewczyk
 */
@UtilityClass
public class UserInput 
{
    /**
    * Gets user input from console using scanner
    *
    * @return string
    */
    static String getUserInputFromConsole()
    { 
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
    /**
    * If no arguments are given then this is called
    *
    * @return string of arguments
    */ 
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
