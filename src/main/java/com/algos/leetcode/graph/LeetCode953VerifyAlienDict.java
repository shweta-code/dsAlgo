package com.algos.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/verifying-an-alien-dictionary/
public class LeetCode953VerifyAlienDict {

    public static void main(String[] args) {

    }

    public boolean isAlienSorted(String[] words, String order) {

        // Algo
        // take 2 words at a time
        // compare characters of those two words for order
        // if there is one miss it means it is not sorted

        // Time complexity -> O(M*N)
        // M = no of words
        // N = max length of any word

        // space complexity

        int[] alphabetOrderForAlienDict = new int[26];
        Arrays.fill(alphabetOrderForAlienDict, -1);
        char[] orderArr = order.toCharArray();
        for (int i = 0; i < order.length(); i++) {
            alphabetOrderForAlienDict[orderArr[i]-'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {

            String prevWord = words[i - 1];
            String currentWord = words[i];
            boolean compare = compare(prevWord, currentWord, alphabetOrderForAlienDict);
            if (!compare) {
                return false;
            }

        }

        return true;
    }

    private boolean compare(String prevWord, String currentWord, int[] alphabetOrderForAlienDict) {
        int j= 0;
        int prevWordLength = prevWord.length();
        int currentWordLength = currentWord.length();
        char[] prevWordArr = prevWord.toCharArray();
        char[] currentWordArr = currentWord.toCharArray();



        while (j < prevWordLength && j < currentWordLength) {
            int indexPrevWordChar = alphabetOrderForAlienDict[prevWordArr[j] - 'a'];
            int indexCurrentWordChar = alphabetOrderForAlienDict[currentWordArr[j] - 'a'];
            if (indexPrevWordChar > indexCurrentWordChar) {
                return false;
            } else if (indexPrevWordChar < indexCurrentWordChar){
                return true;
            }
            j++;
        }
        System.out.println("Current word is prefix of prev word");
        return !(prevWordLength > currentWordLength);
    }

}
