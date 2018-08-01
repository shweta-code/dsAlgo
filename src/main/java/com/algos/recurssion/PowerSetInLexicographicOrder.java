package com.algos.recurssion;


public class PowerSetInLexicographicOrder {

    public static void main(String[] args) {
        String input = "abc";
        generator(input);
    }

    private static void generator(String input) {
        char[] chars = input.toCharArray();
        generate(chars, "", 0);
    }

    private static void generate(char[] chars, String s, int k) {
        for (int i = k; i < chars.length; i++) {
            String y = s + chars[i];
            System.out.println(y);
            generate(chars, y, i + 1);
        }
    }
}

