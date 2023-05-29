package com.algos.leetcode.programmingSkills;

import java.util.List;

public class _422ValidSquare {

    public boolean validWordSquare(List<String> words) {

        int len = words.size();


        for(int j = 0; j< len; j++){
            String refWord = words.get(j);
            int wordLength = refWord.length();
            if(len < wordLength){
                return false;
            }

            for(int i = 0; i< wordLength; i++){
                String wordToCheck = words.get(i);
                if(wordToCheck.length() < j+1){
                    return false;
                }

                if(! (refWord.charAt(i) == wordToCheck.charAt(j))){
                    return false;
                }


            }

            for(int i = wordLength;i< len; i++){
                String wordToCheck = words.get(i);
                if(! (wordToCheck.length() < j+1)){
                    return false;
                }
            }

        }

        return true;

    }
}
