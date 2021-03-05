package com.algos.heap;

import org.junit.Assert;
import org.junit.Test;

public class MaxHeapTest {

    @Test
    public void isLeafNode() {
        MaxHeap maxHeap = new MaxHeap(new int[]{5,4,3});
        boolean isLeafNode = maxHeap.isLeafNode(1);
        Assert.assertTrue(isLeafNode);

    }

    @Test
    public void isRootALeafNode() {
        MaxHeap maxHeap = new MaxHeap(new int[]{5,4,3});
        boolean isLeafNode = maxHeap.isLeafNode(0);
        Assert.assertFalse(isLeafNode);

    }

    @Test
    public void isLeafNode_1() {
        MaxHeap maxHeap = new MaxHeap(new int[]{5,4,3 , 2,1});
        boolean isLeafNode = maxHeap.isLeafNode(0);
        Assert.assertFalse(isLeafNode);

    }


    @Test
    public void isLeafNode_2() {
        MaxHeap maxHeap = new MaxHeap(new int[]{5,4,3,2});
        boolean isLeafNode = maxHeap.isLeafNode(2);
        Assert.assertTrue(isLeafNode);

    }

    @Test
    public void isLeafNode_3() {
        MaxHeap maxHeap = new MaxHeap(new int[]{5,4,3,2});
        boolean isLeafNode = maxHeap.isLeafNode(3);
        Assert.assertTrue(isLeafNode);

    }

    @Test
    public void isLeafNode_4() {
        MaxHeap maxHeap = new MaxHeap(new int[]{5,4,3,2});
        boolean isLeafNode = maxHeap.isLeafNode(1);
        Assert.assertFalse(isLeafNode);

    }

    @Test
    public void contruct() {
        MaxHeap maxHeap = new MaxHeap(new int[]{5});
        Assert.assertEquals(maxHeap.get(0) , 5);
        Assert.assertEquals(maxHeap.length() , 1);

    }


    @Test
    public void contruct_1() {
        MaxHeap maxHeap = new MaxHeap(new int[]{1,2,3});
        Assert.assertEquals(maxHeap.get(0) , 3);
        Assert.assertEquals(maxHeap.length() , 3);

    }

    @Test
    public void contruct_2() {
        MaxHeap maxHeap = new MaxHeap(new int[]{1,2,3 , 4 , 5});
        Assert.assertEquals(maxHeap.get(0) , 5);
        Assert.assertEquals(maxHeap.length() , 5);

    }


    @Test
    public void extractMax_1() {
        MaxHeap maxHeap = new MaxHeap(new int[]{1,2,3 , 4 , 5});
        int max = maxHeap.extract();
        Assert.assertEquals(max , 5);
        Assert.assertEquals(maxHeap.length() , 4);

    }


    @Test
    public void extractMax_2() {
        MaxHeap maxHeap = new MaxHeap(new int[]{6,7,8, 10, 4,9});
        int max = maxHeap.extract();
        Assert.assertEquals(max , 10);
        Assert.assertEquals(maxHeap.length() , 5);

    }



}
