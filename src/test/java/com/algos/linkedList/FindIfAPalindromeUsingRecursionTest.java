package com.algos.linkedList;

import org.junit.Assert;
import org.junit.Test;

public class FindIfAPalindromeUsingRecursionTest {

    @Test
    public void envenNodesPal(){
        LinkedList ll = new LinkedList(new LinkedListNode(1));
        ll.offerLast(new LinkedListNode(2));
        ll.offerLast(new LinkedListNode(2));
        ll.offerLast(new LinkedListNode(1));

        Assert.assertEquals(Boolean.TRUE ,FindIfAPalindromeUsingRecursion.isPal(ll) );
    }

    @Test
    public void envenNodesNotPal(){
        LinkedList ll = new LinkedList(new LinkedListNode(1));
        ll.offerLast(new LinkedListNode(2));
        ll.offerLast(new LinkedListNode(5));
        ll.offerLast(new LinkedListNode(1));

        Assert.assertEquals(Boolean.FALSE ,FindIfAPalindromeUsingRecursion.isPal(ll) );
    }

    @Test
    public void oddnOdesNotAPal(){
        LinkedList ll = new LinkedList(new LinkedListNode(1));
        ll.offerLast(new LinkedListNode(2));
        ll.offerLast(new LinkedListNode(2));
        ll.offerLast(new LinkedListNode(1));
        ll.offerLast(new LinkedListNode(5));

        Assert.assertEquals(Boolean.FALSE ,FindIfAPalindromeUsingRecursion.isPal(ll) );
    }

    @Test
    public void oddNodesPal(){
        LinkedList ll = new LinkedList(new LinkedListNode(1));
        ll.offerLast(new LinkedListNode(2));
        ll.offerLast(new LinkedListNode(2));
        ll.offerLast(new LinkedListNode(2));
        ll.offerLast(new LinkedListNode(1));

        Assert.assertEquals(Boolean.TRUE ,FindIfAPalindromeUsingRecursion.isPal(ll) );
    }
    @Test
    public void singleNodeAlwaysAPal(){
        LinkedList ll = new LinkedList(new LinkedListNode(1));

        Assert.assertEquals(Boolean.TRUE ,FindIfAPalindromeUsingRecursion.isPal(ll) );
    }

    @Test
    public void twoNodesNotPal(){
        LinkedList ll = new LinkedList(new LinkedListNode(1));
        ll.offerLast(new LinkedListNode(2));

        Assert.assertEquals(Boolean.FALSE ,FindIfAPalindromeUsingRecursion.isPal(ll) );
    }

    @Test
    public void twoNodesPal(){
        LinkedList ll = new LinkedList(new LinkedListNode(1));
        ll.offerLast(new LinkedListNode(1));

        Assert.assertEquals(Boolean.TRUE ,FindIfAPalindromeUsingRecursion.isPal(ll) );
    }
}
