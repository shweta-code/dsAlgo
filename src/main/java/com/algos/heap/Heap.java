package com.algos.heap;


/*
Operations on Min Heap:
        1) getMini(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).

        2) extractMin(): Removes the minimum element from MinHeap. Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after removing root.

        3) decreaseKey(): Decreases value of key. The time complexity of this operation is O(Logn). If the decreases key value of a node is greater than the parent of the node, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

        4) insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

        5) delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minum infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin() to remove the key.
                     There is one more approach that I have added;
*/


public class Heap {

    private int heapSize = 0;
    private  static int CAPACITY;
    private int[] arr;

    public Heap(int capacity) {
        CAPACITY = capacity;
        arr = new int[CAPACITY];
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public int insert(int key) throws Exception {

        if(CAPACITY == heapSize){
            throw  new Exception("Heap is full");
        }
        heapSize++;
        arr[heapSize-1] = key;
        heapifyBottomUp(heapSize-1);
        return heapSize;
    }

    public int delete(int index) throws Exception {
        if(index+1 > CAPACITY){
            throw new Exception("Can't delete");
        }
        if(index == 0){
            arr[0] = 0;
        }
        arr[index] = arr[heapSize-1];
        arr[heapSize - 1] = 0;
        heapSize--;
        heapifyTopDown(index);
        return heapSize;

    }

    public int decreaseKey(int index, int newValue){

        arr[index] = newValue;
        heapifyBottomUp(index);
        return heapSize;
    }

    public int extractMin(){

        if(heapSize == 1){
            heapSize--;
            return arr[0];
        }
        int answer = arr[0];
        arr[0] = arr[heapSize -1];
        heapifyTopDown(0);
        arr[heapSize] = 0;
        heapSize--;
        return answer;

    }


    //heapifyBottomUp bottom up
    private void heapifyBottomUp(int i) {

        while(i > 0){
            int parent = getParent(i);
            if(arr[parent] > arr[i]){
                swap(parent,i);
            }
            i = parent;
            //heapifyBottomUp(i);
        }

    }

    //heapify top down
    private void heapifyTopDown(int i) {

        while(i < heapSize){
            int left = getLeft(i);
            int right = getRight(i);
            int smallest = i;
            if(left < heapSize && arr[i] > arr[left]){
                smallest = left;
            }

            if(right < heapSize && arr[i] > arr[right]){
                smallest = right;
            }

            if(smallest != i){
                swap(smallest,i);
                i = smallest;
            } else {
                break;
            }

        }

    }

    private int getLeft(int i) {
        return 2*i + 1;
    }

    private int getRight(int i) {
        return 2*(i + 1);
    }

    private void swap(int parent, int i) {
        int temp = arr[parent];
        arr[parent] = arr[i];
        arr[i] = temp;

    }

    private int getParent(int i) {
        return (i-1)/2;
    }

    public static void main(String[] args) throws Exception {
        Heap heap = new Heap(8);
        heap.insert(5);
        heap.insert(5);
        heap.insert(5);
        heap.insert(2);
        heap.insert(1);
        heap.insert(-1);
        heap.insert(0);
        for (int i : heap.arr) {
            System.out.print(i);
        }
        System.out.println();
        heap.delete(4);
        heap.delete(1);
        for (int i : heap.arr) {
            System.out.print(i);
        }
        System.out.println();
        heap.decreaseKey(2, -1);
        for (int i : heap.arr) {
            System.out.print(i);
        }
        System.out.println();
        heap.extractMin();
        for (int i : heap.arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
