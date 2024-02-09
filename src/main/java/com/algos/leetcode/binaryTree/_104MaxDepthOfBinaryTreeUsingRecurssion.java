package com.algos.leetcode.binaryTree;

import com.algos.binaryTree.TreeNode;


public class _104MaxDepthOfBinaryTreeUsingRecurssion {

    public int maxDepth(TreeNode root) {

        if (null == root) {
            return 0;
        }
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int depth) {
        if (null == node) {
            return depth - 1;
        }

        int leftLevel = dfs(node.left, depth + 1);
        int rightLevel = dfs(node.right, depth + 1);

        return Math.max(leftLevel, rightLevel);
    }
}
