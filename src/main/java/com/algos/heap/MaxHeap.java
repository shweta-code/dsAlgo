package com.algos.heap;


/*
Operations on Max Heap:
        1) getMax(): It returns the root element of Max Heap. Time Complexity of this operation is O(1).

        2) extractMax(): Removes the max element from MinHeap. Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after removing root.

        3) increaseKey(): Increases value of key. The time complexity of this operation is O(Logn). If the increased key value of a node is greater than the parent of the node, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

        4) insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is lesser than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.

        5) delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with maximum infinite by calling increaseKey(). After increaseKey(), the minus infinite value must reach root, so we call extractMax() to remove the key.

                  There is one more approach that I have added;
*/


/*
 *
 * @miniTest
 * //TODO
 * 1) How can we make this class iterable so that we can use forEach syntax?
 * 2) How can we make this class generic?
 *
 * */

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    private int heapSize = 0;
    int CAPACITY;

    public MaxHeap(int capacity) {
        CAPACITY = capacity;

        heap = new Object[CAPACITY];
    }

    @Override
    public int insert(T key) throws Exception {

        if(CAPACITY == heapSize){
            throw  new Exception("Heap is full");
        }
        heapSize++;
        heap[heapSize-1] = key;
        heapifyBottomUp(heapSize-1);
        return heapSize;
    }

    public int increaseKey(int index, T newValue){

        heap[index] = newValue;
        heapifyBottomUp(index);
        return heapSize;
    }

    @Override
    public T get(int index){
        if(index+1 > heapSize){
            throw new NoSuchElementException();
        }
        return (T)heap[index];
    }

    //heapifyBottomUp bottom up
    private void heapifyBottomUp(int i) {

        while(i > 0){
            int parent = getParent(i);
            if(((T)heap[parent]).compareTo(((T)heap[i])) < 0){
                swap(parent,i);
            }
            i = parent;
            //heapifyBottomUp(i);
        }

    }



    //heapify top down
    public void heapifyTopDown(int i) {

        while(i < heapSize){
            int left = getLeft(i);
            int right = getRight(i);
            int largest = i;
            if(left < heapSize && ((T)heap[i]).compareTo(((T)heap[left])) < 0){
                largest = left;
            }

            if(right < heapSize && ((T)heap[i]).compareTo(((T)heap[right])) < 0){
                largest = right;
            }

            if(largest != i){
                swap(largest,i);
                i = largest;
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
        T temp = (T)heap[parent];
        heap[parent] = heap[i];
        heap[i] = temp;

    }

    private int getParent(int i) {
        return (i-1)/2;
    }


    @Override
    public String toString() {
        return  Arrays.toString(heap);
    }

    @Override
    public int size() {
        return heapSize;
    }

    public static void main(String[] args) throws Exception {
        MaxHeap<Integer> maxHeap = new MaxHeap(8);
        maxHeap.insert(5);
        maxHeap.insert(5);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(-1);
        maxHeap.insert(0);
        System.out.println(maxHeap);
        maxHeap.delete(4, maxHeap.size());
        maxHeap.delete(1, maxHeap.size());
        System.out.println(maxHeap);
        maxHeap.increaseKey(2, -1);
        System.out.println(maxHeap);

        maxHeap.extractMax(maxHeap.size());
        System.out.println(maxHeap);
    }

}

