package com.algos.leetcode.programmingSkills;

public class _1768MergeStrings {

    public String mergeAlternately(String word1, String word2) {

        int i = 0;
        int j = 0;
        int k = 0;
        StringBuilder ans = new StringBuilder();
        char[] word1Arr = word1.toCharArray();
        int _1Length = word1Arr.length;
        char[] word2Arr = word2.toCharArray();
        int _2Length = word2Arr.length;
        while (i < _1Length && j < _2Length) {
            if (k % 2 == 0) {
                ans.append(word1Arr[i]);
                i++;
            } else {
                ans.append(word2Arr[j]);
                j++;
            }
            k++;
        }

        while (i < _1Length) {
            ans.append(word1Arr[i]);
            i++;
        }

        while (j < _2Length) {
            ans.append(word2Arr[j]);
            j++;
        }

        return ans.toString();
    }

}
