package com.algos.dynamicProgramming;


public class LongestCommonSubsequence {
    public static void main(String[] args) {
        answer("ABCDGH", "AEDFHR");
    }

    private static void answer(String string1, String string2) {
        char[] input1 = string1.toCharArray();
        char[] input2 = string2.toCharArray();
        int m;
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < input1.length; i++) {
            if (sum > answer) {
                answer = sum;
            }
            sum = 0;
            m = 0;
            for (int j = i; j < input1.length; j++) {

                for (int k = m; k < input2.length; k++) {
                    if (input1[j] == input2[k]) {
                        sum++;
                        m = k + 1 < input2.length ? k + 1 : input2.length - 1;
                        break;
                    }
                }

            }

        }
        System.out.println("answer === " + answer);
    }

}
