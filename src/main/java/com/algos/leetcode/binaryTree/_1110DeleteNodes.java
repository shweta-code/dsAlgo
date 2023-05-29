package com.algos.leetcode.binaryTree;

import com.algos.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _1110DeleteNodes {

    private List<TreeNode> forests = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        if (root == null) {
            return forests;
        }

        if (to_delete.length == 0) {
            forests.add(root);
            return forests;
        }
        // if root is deleted - add left , right
        // if leaf is deleted - nothing happens
        // if a branch node is deleted - add left, right, root

        deleteNode(root, to_delete);
        if (!shouldNodeDelete(root, to_delete)) {
            forests.add(root);
        }
        System.out.println("Size of forests");
        System.out.println(forests.size());
        return forests;

    }

    private TreeNode deleteNode(TreeNode node, int[] toDelete) {
        if (null == node) {
            return null;
        }



        node.left = deleteNode(node.left, toDelete);
        node.right = deleteNode(node.right, toDelete);

        // optimize should we check the entire to_delete array or not
        if (shouldNodeDelete(node, toDelete)) {
            if (null != node.left) {
                System.out.println("Adding to forest");
                System.out.println(node.left.val);
                forests.add(node.left);
            }

            if (null != node.right) {
                System.out.println("Adding to forest");
                System.out.println(node.right.val);
                forests.add(node.right);
            }
            return null;
        }
        return node;
    }

    private boolean shouldNodeDelete(TreeNode node, int[] toDelete) {
        if (node == null) {
            return false;
        }

        for (int toDeleteVal :
                toDelete) {
            if (toDeleteVal == node.val) {
                return true;
            }
        }

        return false;
    }
}
