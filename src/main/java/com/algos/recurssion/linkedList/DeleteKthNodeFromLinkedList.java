package com.algos.recurssion.linkedList;


public class DeleteKthNodeFromLinkedList {

    public static void main(String[] args) {
        DeleteKthNodeFromLinkedList deleteKthNodeFromLinkedList = new DeleteKthNodeFromLinkedList();
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

        Node head = deleteKthNodeFromLinkedList.get(linkedList.getHead(), 3);
        Node node = head;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    public Node get(Node node, int i) {
        if (i <= 0) {
            return node;
        }
        if (node == null) {
            return null;
        }
        if (i == 1) {
            return node.getNext();
        }

        node.setNext(get(node.getNext(), i - 1));
        return node;

    }
}
