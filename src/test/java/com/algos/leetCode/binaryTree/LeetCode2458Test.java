package com.algos.leetCode.binaryTree;

import com.algos.leetcode.binaryTree.LeetCode2458;
import com.algos.leetcode.binaryTree.LeetCode2458.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode2458Test {

    private final LeetCode2458 leetCode2458 = new LeetCode2458();

    @Test
    public void test1() {
        TreeNode treeNode = createTree1();
        int[] ans = leetCode2458.treeQueries(treeNode, new int[]{1, 2});
        Assert.assertArrayEquals(ans, new int[]{1,1});
    }

    @Test
    public void test2() {
        TreeNode treeNode = createTree2();
        int[] ans = leetCode2458.treeQueries(treeNode, new int[]{1, 5, 6, 7});
        Assert.assertArrayEquals(ans, new int[]{0, 0, 1, 2});
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
}
