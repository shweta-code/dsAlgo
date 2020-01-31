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

public class MinHeap<T extends Comparable<T>>{

    private int heapSize = 0;
    private  static int CAPACITY;
    private Object[] heap;

    public MinHeap(int capacity) {
        CAPACITY = capacity;

        heap = new Object[CAPACITY];
    }

    public int insert(T key) throws Exception {

        if(CAPACITY == heapSize){
            throw  new Exception("Heap is full");
        }
        heapSize++;
        heap[heapSize-1] = key;
        heapifyBottomUp(heapSize-1);
        return heapSize;
    }

    public int delete(int index) throws Exception {
        if(index+1 > CAPACITY){
            throw new Exception("Can't delete");
        }
        if(index == 0){
            heap[0] = null;
        }
        heap[index] = heap[heapSize-1];
        heap[heapSize - 1] = null;
        heapSize--;
        heapifyTopDown(index);
        return heapSize;

    }

    public int decreaseKey(int index, T newValue){

        heap[index] = newValue;
        heapifyBottomUp(index);
        return heapSize;
    }

    public T extractMin(){

        if(heapSize == 1){
            heapSize--;
            return (T)heap[0];
        }
        T answer = (T)heap[0];
        heap[0] = heap[heapSize -1];
        heapifyTopDown(0);
        heap[heapSize-1] = null;
        heapSize--;
        return answer;

    }

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
            if(((T)heap[parent]).compareTo(((T)heap[i])) > 0){
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
            if(left < heapSize && ((T)heap[i]).compareTo(((T)heap[left])) > 0){
                smallest = left;
            }

            if(right < heapSize && ((T)heap[i]).compareTo(((T)heap[right])) > 0){
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

    public int size() {
        return heapSize;
    }

    public static void main(String[] args) throws Exception {
        MinHeap<Integer> minHeap = new MinHeap(8);
        minHeap.insert(5);
        minHeap.insert(5);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(-1);
        minHeap.insert(0);
        System.out.println(minHeap);
        minHeap.delete(4);
        minHeap.delete(1);
        System.out.println(minHeap);
        minHeap.decreaseKey(2, -1);
        System.out.println(minHeap);

        minHeap.extractMin();
        System.out.println(minHeap);
    }

}
