package edu.nju.software.js.leetcode.leetcode16;
import java.util.*;
/**
 * Created by sjiang1 on 2016/7/25.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int bestMatch = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                bestMatch = Math.abs(bestMatch-target)<Math.abs(sum-target)?bestMatch:sum;
                if (sum>target){
                    right--;
                }else{
                    left++;
                }
            }
        }

        return bestMatch;

    }
}
