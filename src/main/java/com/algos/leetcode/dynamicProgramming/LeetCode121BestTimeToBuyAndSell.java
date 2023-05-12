package com.algos.leetcode.dynamicProgramming;

public class LeetCode121BestTimeToBuyAndSell {

    public int maxProfit(int[] prices) {

        int profit = 0;
        int minPrice = prices[1];

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;

    }
}
