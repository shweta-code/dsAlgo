package com.algos.leetcode.binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

// Nice Solution
//    https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/solutions/3078705/beats-100-0-ms-16-ms/
public class LeetCode2458 {

//      Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          public TreeNode(int val) { this.val = val; }
          public TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    Map<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
    Map<Integer, Integer> rightMap = new HashMap<>();
    Map<Integer, Integer> removedMap = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {

        populateLeftMap(root);
        populateRightMap(root);


        System.out.println(" Left map ");
        leftMap.forEach((key, val) -> {
            System.out.println("key -> "+ key + " val -> "+ val);
        });


        System.out.println(" Right Map ");
        rightMap.forEach((key, val) -> {
            System.out.println("key -> "+ key + " val -> "+ val);
        });

        removedMap.put(root.val, 0);
        evaluateRemovedMap(root, 0);

        System.out.println(" Removed Map ");
        removedMap.forEach((key, val) -> {
            System.out.println("key -> "+ key + " val -> "+ val);
        });

        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            output[i] = removedMap.get(queries[i]);
        }
        return output;
    }

    private void evaluateRemovedMap(TreeNode node, int level) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            removedMap.put(node.left.val, Math.max(removedMap.get(node.val), rightMap.get(node.val) + level));
        }

        if (node.right != null) {
            removedMap.put(node.right.val, Math.max(removedMap.get(node.val), leftMap.get(node.val) + level));
        }

        evaluateRemovedMap(node.left, level + 1);
        evaluateRemovedMap(node.right, level + 1);
    }

    private void populateLeftMap(TreeNode node) {
        populateLeftMap(node, 0);
    }

    private int populateLeftMap(TreeNode node, int level) {
        if (node == null) {
            return level - 1;
        }

        int leftHeight = populateLeftMap(node.left, level + 1);
        int rightHeight = populateLeftMap(node.right, level + 1);
        leftMap.put(node.val, leftHeight - level);

        return Math.max(leftHeight, rightHeight);
    }

    private void populateRightMap(TreeNode node) {
        populateRightMap(node, 0);
    }

    private int populateRightMap(TreeNode node, int level) {
        if (node == null) {
            return level - 1;
        }

        int leftHeight = populateRightMap(node.left, level + 1);
        int rightHeight = populateRightMap(node.right, level + 1);
        rightMap.put(node.val, rightHeight - level);

        return Math.max(leftHeight, rightHeight);
    }
}
