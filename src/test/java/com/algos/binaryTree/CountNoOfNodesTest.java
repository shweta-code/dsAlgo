package com.algos.binaryTree;

import org.junit.Assert;
import org.junit.Test;

public class CountNoOfNodesTest {

    CountNoOfNodes countNoOfNodes = new CountNoOfNodes();

    @Test
    public void testNoNode(){
//        CountNoOfNodes.TreeNode treeNode = new CountNoOfNodes.TreeNode()
        int noOfNodes = countNoOfNodes.countNoOfNodes(null);
        Assert.assertEquals(0, noOfNodes);
    }

    @Test
    public void testNode1() {

        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode node = new TreeNode(1,left, right);
        int noOfNodes = countNoOfNodes.countNoOfNodes(node);
        Assert.assertEquals(3, noOfNodes);
    }

    @Test
    public void testNode2() {

        TreeNode left = new TreeNode(5, new TreeNode(6, new TreeNode(7), null), null);
        TreeNode node = new TreeNode(1,left,  null);
        int noOfNodes = countNoOfNodes.countNoOfNodes(node);
        Assert.assertEquals(4, noOfNodes);
    }
}
