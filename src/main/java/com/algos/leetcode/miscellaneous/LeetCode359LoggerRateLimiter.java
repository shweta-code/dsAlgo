package com.algos.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode359LoggerRateLimiter {

    private final List<String>[] buffer = new List[10];
    Set<String> tally = new HashSet<>();

    public LeetCode359LoggerRateLimiter() {
//        for (int i = 0; i < 10; i++) {
//            buffer[i] = new ArrayList<>();
//        }
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int processingTS = (timestamp - 1)%10;
        List<String> messagesAtGivenTimestamp = buffer[processingTS];
        for (String messageAtGivenTS :
                messagesAtGivenTimestamp) {
            tally.remove(messageAtGivenTS);
        }
        buffer[processingTS] = new ArrayList<>();
        if (tally.contains(message)) {
            return false;
        } else {
            buffer[processingTS].add(message);
            tally.add(message);
            return true;
        }
    }

}
