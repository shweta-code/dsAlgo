package com.algos.recurssion;


public class Atoi {

    public static void main(String[] args) {
        String s = "12345";
        char[] input = s.toCharArray();
        for (int i = 0; i < input.length; i++) {
            System.out.println(i + " " + input[i]);
        }
        int i = 0;
        int result = 0;
        //int atoi = atoi(input, i, result);
        int atoi = atoi2(input, input.length - 1);
        System.out.println(atoi);
    }

    private static int atoi(char[] input, int i, int result) {


        if (i == input.length) {
            return result;
        } else {

            System.out.println(result);
            result += ((input[input.length - (i + 1)] - 48) * Math.pow(10, i));


            return atoi(input, i + 1, result);
        }
    }

    private static int atoi2(char[] input, int i) {
        if (i == 0) {
            return (input[i] - 48);
        }
        return 10 * atoi2(input, i - 1) + (input[i] - 48);

    }
}
