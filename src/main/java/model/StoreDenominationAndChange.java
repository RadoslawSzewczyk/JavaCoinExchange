package model;

import lombok.Getter;
import lombok.Setter;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Radoslaw Szewczyk
 */
@Getter
@Setter
public class StoreDenominationAndChange 
{
    private AbstractMap.SimpleEntry<List<Integer>, Integer> denominationAndChange;

    /**
     * Parses console arguments
     * 
     * available denominations:1 2 5 10 100 200 50
     * flags: -n 1 2 5 10 100 200 500 -c value
     * @param args
     */
    public void getDenominationAndChangeFromArgs(List<String> args) {
        List<Integer> denominations = new ArrayList<>();
        Integer change = null;

        for (int i = 0; i < args.size(); i++) {
            if ("-n".equals(args.get(i))) {
                i++;
                denominations.addAll(
                    args.stream()
                        .skip(i)
                        .takeWhile(arg -> !arg.startsWith("-"))
                        .map(arg -> {
                            try {
                                return Integer.parseInt(arg);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid denomination: " + arg);
                                return null;
                            }
                        })
                        .filter(denomination -> denomination != null)
                        .collect(Collectors.toList())
                );

                while (i < args.size() && !args.get(i).startsWith("-")) {
                    i++;
                }
                i--;
            } else if ("-c".equals(args.get(i))) {
                i++;
                if (i < args.size()) {
                    try {
                        change = Integer.parseInt(args.get(i));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid change value: " + args.get(i));
                    }
                }
            } else {
                System.out.println("Wrong parameters. Parameters are -n [denomination] -c [change]");
            }
        }

        if (denominations.isEmpty() || change == null) {
            System.out.println("Missing required parameters.");
            return;
        }

        denominationAndChange = new AbstractMap.SimpleEntry<>(denominations, change);
    }

    /**
    * Common getter for denomination and change
    *
    * @return denominations and change
    */
    public AbstractMap.SimpleEntry<List<Integer>, Integer> getDenominationAndChange()
    {
        return denominationAndChange;
    }
}
