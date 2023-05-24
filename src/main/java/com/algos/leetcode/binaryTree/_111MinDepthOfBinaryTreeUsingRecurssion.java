package com.algos.leetcode.binaryTree;

import com.algos.binaryTree.TreeNode;

public class _111MinDepthOfBinaryTreeUsingRecurssion {

    public int minDepth(TreeNode root) {

        if (null == root) {
            return 0;
        }
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int depth) {

        if (null == node.left && null == node.right) {
            return depth;
        } else if (node.left == null) {
            return dfs(node.right, depth + 1);
        } else if (node.right == null) {
            return dfs(node.left, depth + 1);
        } else {
            return Math.min(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
        }
    }

}
