package com.algos.heap;


import org.junit.Assert;
import org.junit.Test;

public class MinHeapTest {



    @Test
    public void positiveInsert() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(5);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        Assert.assertEquals("[1, 2, 4, 5, 3]", minHeap.toString());


    }

    @Test
    public void positiveDelete() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(5);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.delete(1);
        Assert.assertEquals("[1, 3, 4, 5, null]", minHeap.toString());


    }


    @Test
    public void positiveExtractMin() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(5);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.extractMin();
        Assert.assertEquals("[2, 3, 4, 5, null]", minHeap.toString());


    }

    @Test
    public void positiveDecreaseKey() throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>(5);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.decreaseKey(1,-1);
        Assert.assertEquals("[-1, 1, 4, 5, 3]", minHeap.toString());


    }

}
