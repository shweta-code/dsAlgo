package com.algos.towerOfHanoi;


import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class IterativeTowerOfHanoiTest {

    private final IterativeTowerOfHanoi iterativeTowerOfHanoi = new IterativeTowerOfHanoi();

    @Test
    public void _5() {
        final Stack<Integer> stack = iterativeTowerOfHanoi.towerOfHanoi(5);
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(4), stack.pop());
        Assert.assertEquals(Integer.valueOf(5), stack.pop());
    }

    @Test
    public void _1() {
        final Stack<Integer> stack = iterativeTowerOfHanoi.towerOfHanoi(1);
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
    }

    @Test
    public void _2() {
        final Stack<Integer> stack = iterativeTowerOfHanoi.towerOfHanoi(2);
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
    }

    @Test
    public void _3() {
        final Stack<Integer> stack = iterativeTowerOfHanoi.towerOfHanoi(3);
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
    }

    @Test
    public void _4() {
        final Stack<Integer> stack = iterativeTowerOfHanoi.towerOfHanoi(4);
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(4), stack.pop());
    }

    @Test
    public void _6() {
        final Stack<Integer> stack = iterativeTowerOfHanoi.towerOfHanoi(6);
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(4), stack.pop());
        Assert.assertEquals(Integer.valueOf(5), stack.pop());
        Assert.assertEquals(Integer.valueOf(6), stack.pop());
    }


    @Test
    public void _7() {
        final Stack<Integer> stack = iterativeTowerOfHanoi.towerOfHanoi(7);
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(4), stack.pop());
        Assert.assertEquals(Integer.valueOf(5), stack.pop());
        Assert.assertEquals(Integer.valueOf(6), stack.pop());
        Assert.assertEquals(Integer.valueOf(7), stack.pop());
    }
}
