package com.algos.leetcode.programmingSkills;

import java.util.Arrays;
import java.util.Set;

public class _389FindTheDiff {


    public char findTheDifference(String s, String t) {
        int[] alphabets = new int[26];
        for (char c :
                t.toCharArray()) {
            alphabets[c - 'a']++;
        }

        for (char c :
                s.toCharArray()) {
            alphabets[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] == 1) {
                return (char)(i + 'a');
            }
        }


        return 'a';
    }
}
