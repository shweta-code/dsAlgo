package com.algos.leetcode.programmingSkills;

public class _459RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = 1; i <= length / 2; i++) {
            if (length % i == 0) {
                String potetialPattern = s.substring(0, i);
                for (int j = i; j < length; j = j + i) {
                    String match = s.substring(j, j + i);
                    if (match.equals(potetialPattern) && j+i == length) {
                        return true;
                    } else if (!match.equals(potetialPattern)) {
                        break;
                    }
                }
            }
        }

        return false;
    }

}
