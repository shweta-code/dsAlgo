package com.algos.leetCode.programmingSkills;

import com.algos.binaryTree.TreeNode;
import com.algos.leetcode.binaryTree._111MinDepthOfBinaryTreeUsingRecurssion;
import org.junit.Assert;
import org.junit.Test;

public class _111MinDepthOfBinaryTreeUsingRecurssionTest {

    private final _111MinDepthOfBinaryTreeUsingRecurssion minDepth = new _111MinDepthOfBinaryTreeUsingRecurssion();

    @Test
    public void test1() {

        TreeNode root = new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(3, null,
                                new TreeNode(4))));
        int depth = minDepth.minDepth(root);
        Assert.assertEquals(4, depth);
    }
}
