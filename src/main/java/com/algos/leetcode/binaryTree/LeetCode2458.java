package com.algos.leetcode.binaryTree;

// Nice Solution
//    https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/solutions/3078705/beats-100-0-ms-16-ms/
public class LeetCode2458 {


//      Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public int[] treeQueries(TreeNode root, int[] queries) {
        return new int[]{};
    }
}
