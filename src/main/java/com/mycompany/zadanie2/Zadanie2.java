package com.mycompany.zadanie2;
import java.util.AbstractMap;
import model.StoreDenominationAndChange;
import view.UserInput;
/**
 *
 * @author Radoslaw Szewczyk
 */
public class Zadanie2 
{
    StoreDenominationAndChange storeDenominationAndChange = new StoreDenominationAndChange();
    
    public static void main(String[] args) 
    {
        if (args.length == 0) 
        {
            String userInput = UserInput.chooseArgumentsDuringRuntime();
            args = userInput.split(" ");
        }
        Zadanie2 zadanie2 = new Zadanie2();
        zadanie2.storeDenominationAndChange.getDenominationAndChangeFromArgs(args);
        AbstractMap.SimpleEntry<Integer[], Integer> mapa = zadanie2.storeDenominationAndChange.getDenominationAndChange();
        System.out.print("Minimal change:");
        System.out.print(FindMinimalChange.findMinimalChange(mapa));
    }
}
