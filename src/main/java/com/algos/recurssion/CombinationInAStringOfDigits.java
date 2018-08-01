package com.algos.recurssion;

public class CombinationInAStringOfDigits {

    public static void main(String[] args) {
        String input = "123";
        CombinationInAStringOfDigits combinationInAStringOfDigits = new CombinationInAStringOfDigits();
        combinationInAStringOfDigits.generate(input, "", 0);
    }

    private void generate(String input, String s, int k) {
        if (k == input.length()) {
            System.out.println(s);
            return;
        }

        for (int i = 1; i <= input.length() - k; i++) {
            StringBuilder sBuilder = new StringBuilder(s);
            sBuilder.append(input.substring(k, k + i));
            generate(input, sBuilder + " ", k + i);

        }
        //s = sBuilder.toString();
    }
}
