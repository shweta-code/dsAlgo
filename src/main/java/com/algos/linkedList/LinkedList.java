package com.algos.linkedList;

import java.util.Objects;

public class LinkedList {

    private LinkedListNode head;
    private LinkedListNode tail;
    private int length = 0;

    public int getLength() {
        return length;
    }

    public LinkedList(LinkedListNode head) {
        this.head = head;
        this.head.setNext(null);
        this.tail = head;
        length ++;

    }

    public LinkedList() {
        this.head = null;
    }

    public void offerLast(LinkedListNode node){
        if(Objects.isNull(head)){
            this.head = node;
            this.tail = node;
            return;
        }

        this.tail.setNext(node);
        this.tail =  node;
        length++;
    }

    public LinkedListNode getHead() {
        return head;
    }


}
