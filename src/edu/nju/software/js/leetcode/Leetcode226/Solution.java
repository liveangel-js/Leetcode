package edu.nju.software.js.leetcode.Leetcode226;

/**
 * Created by liveangel on 2016-3-8.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (!(root instanceof TreeNode)){
            return root;
        }
        if (root.left!=null){
            invertTree(root.left);

        }
        if (root.right!=null){
            invertTree(root.right);

        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
