package com.algos.leetcode.binaryTree;

import com.algos.binaryTree.TreeNode;

public class _226InvertTree {

    public TreeNode invertTree(TreeNode root) {

        invert(root);
        return root;
    }

    private void invert(TreeNode node) {

        if (node == null) {
            return;
        }
        invert(node.left);
        invert(node.right);

        TreeNode x = node.left;
        node.left = node.right;
        node.right = x;

    }


}
