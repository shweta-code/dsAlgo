package com.algos.binaryTree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class FindLeftHeightOfEachNodeInBinaryTreeTest {

    private final FindLeftHeightOfEachNodeInBinaryTree leftHeight = new FindLeftHeightOfEachNodeInBinaryTree();

    @Test
    public void test1() {

        Map<Integer, Integer> maxHeightOfLeftSubTree = leftHeight.findMaxHeightOfLeftSubTree(createTree1());
        Assert.assertEquals(1, (int) maxHeightOfLeftSubTree.get(3));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(2));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(1));
    }

    @Test
    public void test2() {

        Map<Integer, Integer> maxHeightOfLeftSubTree = leftHeight.findMaxHeightOfLeftSubTree(createTree2());
        Assert.assertEquals(3, (int) maxHeightOfLeftSubTree.get(1));
        Assert.assertEquals(2, (int) maxHeightOfLeftSubTree.get(5));
        Assert.assertEquals(1, (int) maxHeightOfLeftSubTree.get(6));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(7));

    }

    @Test
    public void test3() {

        Map<Integer, Integer> maxHeightOfLeftSubTree = leftHeight.findMaxHeightOfLeftSubTree(createTree3());
        Assert.assertEquals(4, (int) maxHeightOfLeftSubTree.get(1));
        Assert.assertEquals(1, (int) maxHeightOfLeftSubTree.get(2));
        Assert.assertEquals(4, (int) maxHeightOfLeftSubTree.get(3));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(4));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(5));
        Assert.assertEquals(3, (int) maxHeightOfLeftSubTree.get(6));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(7));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(8));
        Assert.assertEquals(2, (int) maxHeightOfLeftSubTree.get(9));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(10));
        Assert.assertEquals(1, (int) maxHeightOfLeftSubTree.get(11));
        Assert.assertEquals(0, (int) maxHeightOfLeftSubTree.get(12));
    }


    //  3
    // 1 2
    public  static TreeNode createTree1() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        return new TreeNode(3,left, right);
    }

    //       1
    //      5
    //     6
    //    7
    public  static TreeNode createTree2() {
        TreeNode left = new TreeNode(5, new TreeNode(6, new TreeNode(7), null), null);
        return new TreeNode(1,left,  null);
    }


    //                      1
    //            2                    3
    //         4    5               6    7
    //                8           9
    //                  10      11
    //                        12
    public  static TreeNode createTree3() {

        return
        new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5, null,
                          new TreeNode(8, null, new TreeNode(10)))),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(9,
                                        new TreeNode(11,
                                                new TreeNode(12), null),null), null),
                        new TreeNode(7)));
    }
}
