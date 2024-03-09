package com.algos.recurssion;

import java.util.*;
import java.util.LinkedList;

public class LC140_WordBreakII_UsingQueue {
    public static void main(String[] args) {

    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        Queue<SentenceAndRemainingString> q = new LinkedList<>();
        q.add(new SentenceAndRemainingString("", s));
        List<String> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            SentenceAndRemainingString sentenceAndRemainingString = q.poll();
            String remainingString = sentenceAndRemainingString.remainingString;
            String sentence = sentenceAndRemainingString.sentence;
            if (remainingString.isEmpty()) {
                sentence = sentence.substring(1);
                ans.add(sentence);
            }
            for (int i = 1; i <= remainingString.length(); i++) {
                String sub = remainingString.substring(0,i);
                if (wordDict.contains(sub)) {
                    q.add(new SentenceAndRemainingString(sentence+" "+sub, remainingString.substring(i)));
                }

            }
        }

        System.out.println(Arrays.toString(ans.toArray()));
        return ans;
    }

    public static class SentenceAndRemainingString{
        public String sentence;
        public String remainingString;

        public SentenceAndRemainingString(String sentence, String remainingString) {
            this.sentence = sentence;
            this.remainingString = remainingString;
        }
    }

}
