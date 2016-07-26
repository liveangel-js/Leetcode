package edu.nju.software.js.leetcode.leetcode144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * Created by sjiang1 on 2016/7/26.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        TreeNode curt = root;

        if(curt==null){
            return result;
        }

        stack.push(curt);
        while(!stack.isEmpty()){
            curt = stack.pop();
            result.add(curt.val);
            if (curt.right != null){
                stack.push(curt.right);
            }
            if (curt.left != null){
                stack.push(curt.left);
            }
        }

        return result;
    }
}