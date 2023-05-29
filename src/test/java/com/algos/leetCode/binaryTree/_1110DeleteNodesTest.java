package com.algos.leetCode.binaryTree;

import com.algos.binaryTree.TreeNode;
import com.algos.leetcode.binaryTree._1110DeleteNodes;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _1110DeleteNodesTest {

    private final _1110DeleteNodes deleteNodes = new _1110DeleteNodes();

    @Test
    public void test1() {
        List<TreeNode> treeNodes = deleteNodes.delNodes(null, new int[]{});
        Assert.assertArrayEquals(new TreeNode[]{}, treeNodes.toArray());
    }

    @Test
    public void test2() {
        List<TreeNode> treeNodes = deleteNodes.delNodes(new TreeNode(5), new int[]{});
        Assert.assertEquals(treeNodes.size(),1);

        Assert.assertEquals(5, (int)treeNodes.get(0).val);
    }

    @Test
    public void test3() {
        List<TreeNode> treeNodes = deleteNodes.delNodes(new TreeNode(5), new int[]{});
        Assert.assertEquals(treeNodes.size(),1);

        Assert.assertEquals(5, (int)treeNodes.get(0).val);
    }

    @Test
    public void test4() {
        List<TreeNode> treeNodes = deleteNodes.delNodes(createTree3(), new int[]{4,6});
        Assert.assertEquals(2, treeNodes.size());

        Assert.assertEquals(9, (int)treeNodes.get(0).val);
        Assert.assertEquals(1, (int)treeNodes.get(1).val);
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
