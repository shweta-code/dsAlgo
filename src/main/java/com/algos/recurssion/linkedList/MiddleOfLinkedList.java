package com.algos.recurssion.linkedList;


public class MiddleOfLinkedList {

    public static void main(String[] args) {
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        LinkedList linkedList = new LinkedList();
        final Node node1 = new Node(null, 1);
        final Node node2 = new Node(null, 2);
        final Node node3 = new Node(null, 3);
        final Node node4 = new Node(null, 4);
        //final Node node5 = new Node(null, 5);
        //final Node node6 = new Node(null, 6);
        //final Node node7 = new Node(null, 7);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        //node4.setNext(node5);
        //node5.setNext(node6);
        //node6.setNext(node7);
        linkedList.setHead(node1);
        final Node node = middleOfLinkedList.find(node1, node1.getNext().getNext());
        System.out.println(node.getData());

    }

    private Node find(Node node1, Node node2) {
        if (node2 == null || node2.getNext() == null) {
            return node1;
        }
        return find(node1.getNext(), node2.getNext().getNext());

    }
}
