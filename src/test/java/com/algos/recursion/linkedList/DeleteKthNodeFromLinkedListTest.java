package com.algos.recursion.linkedList;


import com.algos.recurssion.linkedList.DeleteKthNodeFromLinkedList;
import com.algos.recurssion.linkedList.LinkedList;
import com.algos.recurssion.linkedList.Node;
import org.junit.Assert;
import org.junit.Test;

public class DeleteKthNodeFromLinkedListTest {

    private final DeleteKthNodeFromLinkedList deleteKthNodeFromLinkedList = new DeleteKthNodeFromLinkedList();

    @Test
    public void positive() {

        LinkedList linkedList = new LinkedList();
        final Node node1 = new Node(null, 1);
        final Node node2 = new Node(null, 2);
        final Node node3 = new Node(null, 3);
        final Node node4 = new Node(null, 4);
        final Node node5 = new Node(null, 5);
        final Node node6 = new Node(null, 6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        linkedList.setHead(node1);
        deleteKthNodeFromLinkedList.get(linkedList.getHead(), 2);
        Assert.assertEquals(3, linkedList.getHead().getNext().getData());


    }

    @Test
    public void withKMoreThanLength() {
        LinkedList linkedList = new LinkedList();
        final Node node1 = new Node(null, 1);
        final Node node2 = new Node(null, 2);
        final Node node3 = new Node(null, 3);
        node1.setNext(node2);
        node2.setNext(node3);
        linkedList.setHead(node1);
        deleteKthNodeFromLinkedList.get(linkedList.getHead(), 4);
        Assert.assertEquals(1, linkedList.getHead().getData());
        Assert.assertEquals(2, linkedList.getHead().getNext().getData());
        Assert.assertEquals(3, linkedList.getHead().getNext().getNext().getData());
    }

    @Test
    public void withKEqualTo1() {
        LinkedList linkedList = new LinkedList();
        final Node node1 = new Node(null, 1);
        final Node node2 = new Node(null, 2);
        final Node node3 = new Node(null, 3);
        final Node node4 = new Node(null, 4);
        final Node node5 = new Node(null, 5);
        final Node node6 = new Node(null, 6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        linkedList.setHead(node1);
        deleteKthNodeFromLinkedList.get(linkedList.getHead(), 1);
        Assert.assertEquals(1, linkedList.getHead().getData());
    }
}
