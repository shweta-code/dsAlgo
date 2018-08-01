package com.algos.recurssion;

public class ReverseALinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        node1.next = node2;
        node2.next = node3;
        list.head = node1;

        list.head = reverseList(list.head);
        System.out.println(list.head.data);
        System.out.println(list.head.next.data);
        System.out.println(list.head.next.next.data);
        //System.out.println(list.head.next.next.next.data);

    }

    private static Node reverseList(Node node) {
        if (null != node.next) {
            Node head = reverseList(node.next);
            if (node.next != null) {
                node.next.next = node;
            }
            node.next = null;
            return head;
        } else {
            return node;
        }


        //return node;

    }
}

class LinkedList {
    Node head;
}

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}