package com.algos.recurssion;


public class SumTriangleFromArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        SumTriangleFromArray sumTriangleFromArray = new SumTriangleFromArray();
        sumTriangleFromArray.generate(input, input.length);
    }

    private void generate(int[] input, int length) {
        if (length == 0) {
            return;
        }
        int[] temp = new int[input.length];
        for (int i = 0; i < input.length - 1; i++) {
            temp[i] = input[i] + input[i + 1];
        }
        generate(temp, length - 1);
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
