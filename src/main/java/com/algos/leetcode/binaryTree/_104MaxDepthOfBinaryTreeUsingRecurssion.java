package com.algos.leetcode.binaryTree;

import com.algos.binaryTree.TreeNode;
import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

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
