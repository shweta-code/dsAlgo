package com.algos.leetcode.combinatorics;

import java.util.Arrays;

// In Progress - The given solution is wrong.
// Try to use BigInteger here
public class _2514LeetCode {
    private final long[] factorial = new long[1000];

    public _2514LeetCode() {
        factorial[0] = 1;
    }

    public int countAnagrams(String s) {
        /*factorial[0] = 1*/


        String[] words = s.split(" ");
        int noOfWords = words.length;
        int[][] alphOccCount = new int[noOfWords][26];
        for(int  i = 0; i<noOfWords ; i++){
            // Not sure if this initialization is needed
            alphOccCount[i] = new int[26];

        }

        for(int i = 0 ; i < noOfWords; i++){

            String word = words[i];
            int[] alphOccCountForWord = alphOccCount[i];

            for(int j = 0 ; j < word.length(); j++){

                char charAtJ = word.charAt(j);
                alphOccCountForWord[charAtJ - 'a']++;

            }


        }

        System.out.println(Arrays.toString(alphOccCount));

        long totalCombinations = 1;
        for(int i = 0; i< noOfWords; i++){
            String word = words[i];
            int[] alphOccCountForWord = alphOccCount[i];

            int wordLen = word.length();
            long wordLenFact;
            wordLenFact = factorial(wordLen);
            long combinationsOfWord = wordLenFact;
            for (int j = 0; j < 26; j++)
            {
                combinationsOfWord = combinationsOfWord / factorial(alphOccCountForWord[j]);
            }

            totalCombinations = combinationsOfWord * totalCombinations;
        }


        return (int) (totalCombinations%(7+Math.pow(10,9)));
    }


    // protected for UT
    public long factorial(int n){


        if(n == 0){
            return 1;
        }

        factorial[n] = n * factorial(n-1);
        return factorial[n];


    }
    // Calrifying questions->
    // 1. spaces to remin intact
    // 2. small case
    // 3. max length of word - know the boubds
    // 4. max length of string
}
