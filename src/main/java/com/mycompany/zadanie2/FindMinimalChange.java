package com.mycompany.zadanie2;

import java.util.AbstractMap;
import java.util.Arrays;
/**
 *
 * @author Radoslaw Szewczyk
 */
public class FindMinimalChange 
{
    static Integer findMinimalChange(AbstractMap.SimpleEntry<Integer[], Integer> denominationAndChange)
    {
        Integer[] denominations = denominationAndChange.getKey();
        int change = denominationAndChange.getValue();

        int[] dp = new int[change + 1];
        
        Arrays.fill(dp, change + 1);

        for (int i = 1; i <= change; i++) {
            for (Integer coin : denominations) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[change] > change ? -1 : dp[change];
    }
}
