package com.algos.recurssion;

import java.util.*;

public class LC140_WordBreakII_UsingRecursion {
    public static void main(String[] args) {

    }

    public List<String> wordBreak(String s, List<String> wordDict) {


        Set<String> set = new HashSet<>(wordDict);
        List<String> stringList = wordBreak(s, set);
        System.out.println(Arrays.toString(stringList.toArray()));
        return stringList;
    }

    public void wordBreak(String s, Set<String> wordDict, int startForCurrentIteration, StringBuilder sentence, List<String> sentences) {
        if (startForCurrentIteration == s.length()) {
            sentence.replace(sentence.length() - 1, sentence.length(), "");
            sentences.add(sentence.toString());
            System.out.println(Arrays.toString(sentences.toArray()));
        }

        //for(int start = startForCurrentIteration; start<s.length(); start++){
            for (int end = startForCurrentIteration + 1; end <= s.length(); end++) {
                String sub = s.substring(startForCurrentIteration, end);
                if (wordDict.contains(sub)) {
                    StringBuilder newString = new StringBuilder(sentence);
                    addWordToSentence(newString, sub);
                    System.out.println(newString);
                    wordBreak(s, wordDict, end, newString, sentences);
                }
            }
        //}
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (wordDict.contains(sub)) {
                StringBuilder sentence = new StringBuilder();
                addWordToSentence(sentence, sub);
                System.out.println(sentence);
                wordBreak(s, wordDict, i, sentence, ans);
            }
        }
        return ans;
    }

    private void addWordToSentence(StringBuilder sentence, String word) {
        sentence.append(word);
        sentence.append(" ");
    }

}
