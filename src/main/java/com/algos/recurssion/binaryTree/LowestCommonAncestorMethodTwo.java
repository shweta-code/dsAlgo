package com.algos.recurssion.binaryTree;


public class LowestCommonAncestorMethodTwo {

    public static void main(String[] args) {

        Node root = new Node(0, null, null);
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, null, null);
        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);
        Node node8 = new Node(8, null, null);
        Node node9 = new Node(9, null, null);
        Node node10 = new Node(10, null, null);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setLeft(node7);
        node3.setRight(node8);
        node5.setLeft(node9);
        node5.setRight(node10);
        LowestCommonAncestorMethodTwo lowestCommonAncestorMethodTwo = new LowestCommonAncestorMethodTwo();
        final Node node = lowestCommonAncestorMethodTwo.find(root, 5, 6);
        System.out.println(node.getData());

    }

    private Node find(Node root, int i, int i1) {
        if (root == null) {
            return null;
        }
        if (root.getData() == i || root.getData() == i1) {
            return root;
        }
        Node one = find(root.getLeft(), i, i1);
        Node two = find(root.getRight(), i, i1);
        if (one != null && two != null) {
            return root;
        } else if (one != null) {
            return one;

        } else {
            return two;

        }


    }


}
