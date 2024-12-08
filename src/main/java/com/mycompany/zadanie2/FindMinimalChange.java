package com.mycompany.zadanie2;

import java.util.AbstractMap;
import java.util.Arrays;
import model.NegativeException;
import java.util.List;
import lombok.experimental.UtilityClass;
/**
 *
 * @author Radoslaw Szewczyk
 */
@UtilityClass
public class FindMinimalChange 
{
    /**
    * Calculates minimal number of coins to make the change
    *
    * @param denominationAndChange pair of available denominations and change.
    * @return number of coins to make the change.
    */
    public static Integer findMinimalChange(AbstractMap.SimpleEntry<List<Integer>, Integer> denominationAndChange) throws NegativeException {
    List<Integer> denominations = denominationAndChange.getKey();
    int change = denominationAndChange.getValue();

    if (change < 0) {
        throw new NegativeException("Change cannot be negative.");
    }

    int[] dp = new int[change + 1];
    Arrays.fill(dp, change + 1);
    dp[0] = 0;

    for (int i = 1; i <= change; i++) {
        for (Integer coin : denominations) {
            if (coin <= 0) {
                throw new NegativeException("Coin cannot be negative or 0");
            }
            if (coin <= i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[change] > change ? -1 : dp[change];
}
}
