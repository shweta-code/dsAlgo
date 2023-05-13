package com.algos.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class FindLeftHeightOfEachNodeInBinaryTree {

    Map<Integer, Integer> map = new HashMap<>();
    public Map<Integer, Integer> findMaxHeightOfLeftSubTree(TreeNode node) {
//        Assumption here is nodes are values 0-(n-1)
//             0
//          1     2

        if (node == null) {
            return map;
        }
        findMaxHeightOfLeftSubTree(node, 0);
        return map;

    }

    public int findMaxHeightOfLeftSubTree(TreeNode node, int height) {
        if (null == node.val) {
            return height - 1;
        }

        int leftHeight = findMaxHeightOfLeftSubTree(node.left, height+1);
        int rightHeight = findMaxHeightOfLeftSubTree(node.right, height + 1);
        map.put(node.val, leftHeight - height);


        return Math.max(leftHeight, rightHeight);
    }

    
}
