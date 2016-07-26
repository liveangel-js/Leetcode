package edu.nju.software.js.leetcode.leetcode173;

/**
 * Created by sjiang1 on 2016/7/26.
 */

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;

    public BSTIterator(TreeNode root) {
        curt = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (curt!=null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while(curt!=null){
            stack.push(curt);
            curt = curt.left;
        }

        curt = stack.pop();
        int small = curt.val;
        curt = curt.right;
        return small;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */