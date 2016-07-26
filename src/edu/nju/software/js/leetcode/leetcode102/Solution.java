package edu.nju.software.js.leetcode.leetcode102;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sjiang1 on 2016/7/26.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root ==null){
            return result;
        }
        int size= 1;
        int newSize =0;
        List<Integer> subResult = new ArrayList<Integer>();
        queue.offer(root);

        while(size>0){
            TreeNode tmp = queue.poll();
            subResult.add(tmp.val);
            if (tmp.left!=null){
                queue.offer(tmp.left);
                newSize++;
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
                newSize++;
            }

            size--;

            if(size ==0){
                result.add(subResult);
                subResult = new ArrayList<Integer>();
                System.out.print(subResult.toString());
                size = newSize;
                newSize=0;
            }

        }
        return result;

    }
}
