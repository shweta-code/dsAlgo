package com.algos.heap;

public abstract class Heap<T extends Comparable<T>> {
    protected Object[] heap;

    abstract int insert(T key) throws Exception;

    protected int delete(int index, int heapSize) throws Exception {
        if(index+1 > heap.length){
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

    abstract void heapifyTopDown(int index);

    protected T extractMax(int heapSize){

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

    abstract T get(int index);

    abstract int size();
}
