package edu.nju.software.js.leetcode.leetcode121;

import java.util.Arrays;

/**
 * Created by sjiang1 on 2016/7/26.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int bestProfix = 0;
        for(int i =1; i<prices.length;i++){
            min = prices[i-1]<min? prices[i-1]:min;
            bestProfix = bestProfix > (prices[i] - min)? bestProfix: prices[i]-min;
        }
        return bestProfix;
    }
    public static void main(String args[]){

        new Solution().maxProfit(new int[]{7, 6, 4, 3, 1});
    }
}
