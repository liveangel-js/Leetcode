package edu.nju.software.js.leetcode.leetcode127;

/**
 * Created by sjiang1 on 2016/7/26.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int []left = new int[prices.length];
        int []right = new int[prices.length];

        // count left first
        int min = prices[0];
        left[0] = 0;
        for (int i = 1; i < prices.length;i++){
            min = Math.min(prices[i-1], min);
            left[i] = Math.max(left[i-1], prices[i] - min);
        }
        int max= prices[prices.length - 1];;
        right[prices.length -1] = 0;
        for (int i=prices.length-2;i>=0;i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max-prices[i]);

        }
        int profit = 0;
        for (int i=0;i<prices.length;i++){
            profit = Math.max(left[i] + right[i], profit);
        }

        return profit;
    }

    public static void main(String args[]){
        new Solution().maxProfit(new int[]{1,2,4});
    }



}
