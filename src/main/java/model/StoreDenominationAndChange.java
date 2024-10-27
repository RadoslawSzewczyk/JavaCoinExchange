package model;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Radoslaw Szewczyk
 */

public class StoreDenominationAndChange 
{
    private AbstractMap.SimpleEntry<Integer[], Integer> denominationAndChange;
    /**
     * Parses console arguments
     * 
     * available denominations:1 2 5 10 100 200 50
     * flags: -n 1 2 5 10 100 200 500 -c value
     * @param args
     */
    public void getDenominationAndChangeFromArgs(String[] args)
    {
        List<Integer> denominations = new ArrayList<>();
        Integer change = null;

        for (int i = 0; i < args.length; i++) 
        {
            if ("-n".equals(args[i])) 
            {
                i++;
                while (i < args.length && !args[i].startsWith("-")) 
                {
                    try {
                        denominations.add(Integer.parseInt(args[i]));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid denomination: " + args[i]);
                    }
                    i++;
                }
                i--;
            } else if ("-c".equals(args[i])) 
            {
                i++;
                if (i < args.length) 
                {
                    try {
                        change = Integer.parseInt(args[i]);
                    } catch (NumberFormatException e) 
                    {
                        System.out.println("Invalid change value: " + args[i]);
                    }
                }
            } else 
            {
                System.out.println("Wrong parameters. Parameters are -n [denomination] -c [change]");
            }
        }

        if (denominations.isEmpty() || change == null) 
        {
            System.out.println("Missing required parameters.");
            return;
        }

        denominationAndChange = new AbstractMap.SimpleEntry<>(denominations.toArray(new Integer[0]), change);
    }
    /**
    * Common getter for denomination and change
    *
    * @return denominations and change
    */
    public AbstractMap.SimpleEntry<Integer[], Integer> getDenominationAndChange()
    {
        return denominationAndChange;
    }
}
