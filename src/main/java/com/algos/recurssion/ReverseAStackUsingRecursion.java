package com.algos.recurssion;


import java.util.Stack;

public class ReverseAStackUsingRecursion {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        reverseStack(stack);

        System.out.println("reversed");

        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int no = stack.pop();
            reverseStack(stack);
            putNoInEnd(no, stack);
        }

    }

    private static void putNoInEnd(int no, Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            final Integer pop = stack.pop();
            putNoInEnd(no, stack);
            stack.push(pop);
        } else {
            stack.push(no);
        }
    }
}
