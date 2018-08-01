package com.algos.recurssion.binarySearchTree;


import java.util.HashSet;
import java.util.Set;

public class LeafNodesfromPreorderOfABinarySearchTree {

    public static void main(String[] args) {
        int[] preorder = {3, 2, 4};
        LeafNodesfromPreorderOfABinarySearchTree leafNodesfromPreorderOfABinarySearchTree = new LeafNodesfromPreorderOfABinarySearchTree();
        Set<Integer> leafNodes = leafNodesfromPreorderOfABinarySearchTree.printNodes(preorder);
        for (Integer leafNode : leafNodes) {
            System.out.println(leafNode);
        }
    }

    private Set<Integer> printNodes(int[] preorder) {
        Set<Integer> set = new HashSet<>();
        preorder(0, preorder.length - 1, preorder, set);
        return set;

    }

    private void preorder(int root, int end, int[] preorder, Set<Integer> set) {
        if (root == end) {
            set.add(preorder[root]);
            return;
        }
        int firstMin = -1;
        int firstMax = preorder.length + 1;
        for (int i = root + 1; i <= end; i++) {
            if (preorder[i] < preorder[root]) {
                firstMin = i;
                break;
            }
        }

        for (int i = firstMin + 1; i <= end; i++) {
            if (preorder[i] > preorder[root]) {
                firstMax = i;
                break;
            }
        }

        preorder(firstMin, firstMax - 1, preorder, set);
        preorder(firstMax, end, preorder, set);

    }
}
