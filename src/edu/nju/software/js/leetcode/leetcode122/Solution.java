package edu.nju.software.js.leetcode.leetcode122;

/**
 * Created by sjiang1 on 2016/7/26.
 */
public class Solution {
    public int maxProfit(int[] prices) {

        int [] diff = new int[prices.length];
        int total = 0;
        for(int i=1; i <prices.length; i++){
            diff[i] = prices[i] - prices[i-1];
            System.out.println(diff[i]);
            if(diff[i]>0){
                total +=diff[i];
            }
        }
        return total;
    }

    public static void main(String agrs[]){
        new Solution().maxProfit(new int[]{1,2,4});
    }
}
