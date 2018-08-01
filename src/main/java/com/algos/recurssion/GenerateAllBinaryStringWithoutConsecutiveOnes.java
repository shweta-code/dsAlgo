package com.algos.recurssion;


import java.util.HashSet;
import java.util.Set;

public class GenerateAllBinaryStringWithoutConsecutiveOnes {

    public static void main(String[] args) {
        GenerateAllBinaryStringWithoutConsecutiveOnes generateAllBinaryStringWithoutConsecutiveOnes = new GenerateAllBinaryStringWithoutConsecutiveOnes();
        System.out.println(generateAllBinaryStringWithoutConsecutiveOnes.generate(4));
    }

    private Set<String> generate(int k) {
        Set<String> list = new HashSet<>();
        appendBit("", k, list);
        appendBit("", k, list);
        return list;

    }

    private void appendBit(String s, int k, Set<String> list) {
        if (k == 0) {
            list.add(s);
        } else {
            if (!s.equals("") && s.substring(s.length() - 1, s.length()).equals("1")) {
                appendBit(s + "0", k - 1, list);
            } else {
                appendBit(s + "0", k - 1, list);
                appendBit(s + "1", k - 1, list);
            }
        }
    }

}
