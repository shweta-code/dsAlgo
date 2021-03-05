package com.algos.heap;

// A heap is a complete binary tree such that
// node is greater than child Nodes
public class MaxHeap {

    //internal data structure
    private final int[] heap;
    private int lastFilledIndex = -1;

    public MaxHeap(int[] heap ) {
        this.heap = new int[heap.length];
        for (int j : heap) {
            add(j);
        }
    }

    public void add(int no){
        if(heap.length-1 == lastFilledIndex){
            //Can throw exception
            return;
        }
        heap[++lastFilledIndex] = no;
        bottomToTopHeapify(lastFilledIndex);
    }

    public int length(){
        return lastFilledIndex+1;
    }

    private void bottomToTopHeapify(int index) {
        if(index <= 0){
            return;
        }
        int parentIndex = parentIndex(index);
        if(heap[parentIndex] < heap[index]){
            swap(parentIndex , index);
            bottomToTopHeapify(parentIndex);
        }
    }

    private int parentIndex(int index) {
        if(index <= 0){
            return -1;
        }
        return (index-1)/2;
    }

    public int get(int index){
        return heap[index];
    }

    public int extract(){

        if(heap.length == 0){
            return Integer.MIN_VALUE;
        }
        int max = heap[0];
        swap(0 , lastFilledIndex);
        heap[lastFilledIndex] = Integer.MIN_VALUE;
        lastFilledIndex--;
        topToBottomHeapify(0);

        return max;

    }

    private void topToBottomHeapify(int index) {

        if(index > lastFilledIndex){
            return;
        }
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);
        int maxOfNodeAndItsChildren = index;
        if(this.heap[leftChildIndex] > this.heap[maxOfNodeAndItsChildren]){
            maxOfNodeAndItsChildren = leftChildIndex;
        }

        if(rightChildIndex != -1 && this.heap[rightChildIndex] > this.heap[maxOfNodeAndItsChildren]){
            maxOfNodeAndItsChildren = rightChildIndex;
        }

        swap(maxOfNodeAndItsChildren , index);
        if(maxOfNodeAndItsChildren != index){
            topToBottomHeapify(maxOfNodeAndItsChildren);
        }


    }

    private void swap(int index1, int index) {
        int temp = heap[index1];
        heap[index1] = heap[index];
        heap[index] = temp;
    }

    private int rightChildIndex(int index) {
        if(2*index + 2 >= heap.length){
            return -1;
        }
        return 2*index + 2;
    }

    private int leftChildIndex(int index) {
        if(2*index + 1 >= heap.length){
            return -1;
        }
        return 2*index + 1;
    }

    protected boolean isLeafNode(int index) {
        return (heap.length / 2) - 1 < index;
    }

}

// API
// heap .. add - heapify .. delete