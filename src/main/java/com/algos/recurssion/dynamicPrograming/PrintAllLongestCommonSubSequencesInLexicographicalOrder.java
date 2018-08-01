package com.algos.recurssion.dynamicPrograming;


import java.util.HashSet;
import java.util.Set;

public class PrintAllLongestCommonSubSequencesInLexicographicalOrder {

    private String string1;
    private String string2;

    private PrintAllLongestCommonSubSequencesInLexicographicalOrder(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public static void main(String[] args) {
        String str1 = "abcabcaa", str2 = "acbacba";
        PrintAllLongestCommonSubSequencesInLexicographicalOrder printAllLongestCommonSubSequencesInLexicographicalOrder
                = new PrintAllLongestCommonSubSequencesInLexicographicalOrder(str1, str2);
        final Set<String> print = printAllLongestCommonSubSequencesInLexicographicalOrder.print();
        for (String s : print) {
            System.out.println(s);
        }
    }

    private Set<String> print() {

        Set<String> set = new HashSet<>();
        recur(0, 0, string1.toCharArray(), string2.toCharArray(), set, "");
        return set;
    }

    private void recur(int index1, int index2, char[] string1, char[] string2, Set<String> set, String result) {

        if (index1 == string1.length || index2 == string2.length) {
            System.out.println(result);
            return;
        }
        if (string1[index1] == string2[index2]) {
            recur(index1 + 1, index2 + 1, string1, string2, set, result + string1[index1]);
        } else {
            recur(index1 + 1, index2, string1, string2, set, result);
            recur(index1, index2 + 1, string1, string2, set, result);
        }
    }
}
