package edu.nju.software.js.leetcode.leetcode15;

import java.util.*;

/**
 * Created by sjiang1 on 2016/7/25.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();

        if(nums==null || nums.length<3){
            return rst;
        }
        Arrays.sort(nums);

        for(int i=0; i< nums.length-2;i++){
            if(i!=0 && nums[i] ==nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum>0){
                    right--;
                }else if (sum<0){
                    left++;
                }else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    rst.add(tmp);
                    while(left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    if (left<right){
                        left++;
                    }
                    while(left<right && nums[right] == nums[right-1]){
                        right--;
                    }
                    if (left<right){
                        right--;
                    }
                }

            }

        }
        return rst;

    }

    public static void main(String argsp[]){
        int [] nums = {-2,0,1,1,2};
        System.out.println(new Solution().threeSum(nums));
    }
}