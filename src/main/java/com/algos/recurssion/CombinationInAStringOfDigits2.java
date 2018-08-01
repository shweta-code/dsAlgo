package com.algos.recurssion;


public class CombinationInAStringOfDigits2 {

    public static void main(String[] args) {
        String input = "1234";
        CombinationInAStringOfDigits2 combinationInAStringOfDigits = new CombinationInAStringOfDigits2();
        combinationInAStringOfDigits.generate(input, "", input.length());
    }

    private void generate(String input, String s, int l) {
        String k = s.replace(" ", "");
        if (k.length() == l) {
            System.out.println(s);
            return;
        }

        for (int i = 1; i <= input.length(); i++) {
            StringBuilder sBuilder = new StringBuilder(s);
            sBuilder.append(input.substring(0, i));
            generate(input.substring(i, input.length()), sBuilder + " ", l);

        }
        //s = sBuilder.toString();
    }
}
