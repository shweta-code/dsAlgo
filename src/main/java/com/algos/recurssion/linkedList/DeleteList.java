package com.algos.recurssion.linkedList;


public class DeleteList {

    public static void main(String[] args) {
        DeleteList deleteList = new DeleteList();
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
        linkedList.setHead(deleteList.delete(node1));
        System.out.println(linkedList.getHead());
    }

    private Node delete(Node node1) {
        if (node1 == null) {
            return null;

        }
        node1 = delete(node1.getNext());
        return node1;
    }


}
