package com.algos.leetcode.programmingSkills;

public class _28FirstOccurence {

    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }

        char[] needleArr = needle.toCharArray();
        char[] hayStackArr = haystack.toCharArray();
        for (int j = 0; j < hayStackArr.length; j++) {
            System.out.println("hayStackArr[j] -> "+ hayStackArr[j]);
            if (needleArr[0] == hayStackArr[j]) {
                int i = 0;
                int k = j;
                System.out.println(" Start comparing");
                while (i < needleArr.length && k < hayStackArr.length) {
                    System.out.println(" needleArr[i] -> " + needleArr[i]);
                    System.out.println("hayStackArr[k] -> "+ hayStackArr[k]);
                    if (needleArr[i] == hayStackArr[k]) {
                        i++;
                        k++;
                    }
                }

                if (i == needleArr.length) {
                    System.out.println("Found equal");
                    return j;
                }
            }
        }

        return -1;
    }
}
