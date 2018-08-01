package com.algos.recurssion;

public class CountSubstringsWithFirstAndLastChars {

    public static void main(String[] args) {
        String input = "aba";


        int count = count(input.toCharArray(), 0, input.length() - 1, input.length());
        System.out.println(count);
        count(input);


    }

    //Iterative way of doing it
    private static void count(String input) {
        int count = 0;
        final char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    //System.out.println(input.substring(i , j+1));
                    count++;
                }
            }
        }

        System.out.println(count);
    }


    //Recursive way of doing it
    private static int count(char[] chars, int start, int end, int length) {

        if (length < 2) {

            return 0;
        }
        int count = 0;
        if (chars[start] == chars[end]) {
            count++;
        }
        count += count(chars, start + 1, end, length - 1) +
                count(chars, start + 1, end - 1, length - 2) +
                count(chars, start, end - 1, length - 1);
        return count;
    }
}

/*abcab count = 0
abca count = 1     bc     bca
abc
ab b 1 bc
a 1*/