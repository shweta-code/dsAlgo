package com.algos.towerOfHanoi;


import java.util.Stack;

public class IterativeTowerOfHanoi {

    public static void main(String[] args) {
        int input = 4;
        IterativeTowerOfHanoi iterativeTowerOfHanoi = new IterativeTowerOfHanoi();
        iterativeTowerOfHanoi.towerOfHanoi(input);
    }

    private static void moveDisk(Stack<Integer> from, Stack<Integer> to) {
        to.push(from.pop());
    }

    public Stack<Integer> towerOfHanoi(int input) {
        Stack<Integer> from = new Stack<>();
        Stack<Integer> to = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        for (int i = input; i > 0; i--) {
            from.push(i);
        }

        if (from.size() == 1) {
            moveDisk(from, to);
        }
        while (!from.isEmpty()) {
            moveDisk(from, aux);
            moveDisk(from, to);
            moveDisk(aux, to);
            if (!from.empty() && !aux.isEmpty()) {
                if (from.peek() > aux.peek()) {
                    moveDisk(aux, from);
                } else {
                    moveDisk(from, aux);
                }
                Stack<Integer> temp = to;
                to = aux;
                aux = from;
                from = temp;

            } else if (!from.isEmpty()) {
                moveDisk(from, aux);
                Stack<Integer> temp = to;
                to = aux;
                aux = from;
                from = temp;
            } else if (!aux.isEmpty()) {
                moveDisk(aux, from);
                Stack<Integer> temp = to;
                to = aux;
                aux = from;
                from = temp;
            }


        }
        return to;
    }
}
