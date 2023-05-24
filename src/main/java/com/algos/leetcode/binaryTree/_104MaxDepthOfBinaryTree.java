package com.algos.leetcode.binaryTree;

import com.algos.binaryTree.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _104MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        if (null == root) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 1));
        int maxDepth = 0;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> polled = q.poll();
            TreeNode node = polled.getKey();
            Integer height = polled.getValue();
            maxDepth = Math.max(maxDepth, height);
            if (node.left != null) {
                q.add(new Pair<>(node.left, height + 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, height + 1));
            }

        }

        return maxDepth;
    }


}

