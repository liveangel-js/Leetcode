package edu.nju.software.js.leetcode.leetcode18;
import java.util.*;
/**
 * Created by sjiang1 on 2016/7/25.
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums.length<4 || nums == null){
            return rst;
        }
        Arrays.sort(nums);
        int bestMatch = nums[0] + nums[1] + nums[2] + nums[3];
        for(int i=0; i<nums.length-3; i++){
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j=i+1; j<nums.length-2; j++){
                if (j != i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j+1;
                int right = nums.length -1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        rst.add(tmp);
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if (sum>target){
                        right--;
                    }else if (sum<target){
                        left++;
                    }
                }
            }
        }
        return rst;

    }

    public static void main(String args[]){
        int [] a = {-3,-2,-1,0,0,1,2,3};
        System.out.println(new Solution().fourSum(a, 0));
    }
}
