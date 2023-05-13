package com.algos.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CountNoOfNodes {

    public int countNoOfNodes(TreeNode rootNode) {

        if (rootNode == null) {
            return 0;
        }

        Queue<TreeNode> bfsQ = new LinkedList<>();
        int count = 0;
        bfsQ.add(rootNode);
        while (!bfsQ.isEmpty()) {
            TreeNode node = bfsQ.poll();
            count++;
            if (node.left != null) {
                bfsQ.add(node.left);
            }

            if (node.right != null) {
                bfsQ.add(node.right);
            }

        }

        return count;
    }

}
