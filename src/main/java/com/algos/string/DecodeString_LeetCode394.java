package com.algos.string;

import java.util.Stack;

public class DecodeString_LeetCode394 {

    public static void main(String[] args) {
        DecodeString_LeetCode394 test = new DecodeString_LeetCode394();
        /*
        test.decodeString("2[a2[b]2[c]]");
        test.decodeString("2[a2[b2[c]]]");*/
        test.decodeString("2[a]");
        test.decodeString("2[a]3[b]");
    }

    public   String decodeString(String encodedString) {
        char[] encodedArr = encodedString.toCharArray();
        Stack<Integer> openingBracketIndex = new Stack<>();
        Stack<Integer> closingBracketIndex = new Stack<>();
        Stack<Integer> kIndex = new Stack<>();
        int length = encodedString.length();
        int i = 0;
        while (i < length) {
            if(encodedArr[i] == ']'){
                //closingBracketIndex.push(i);
                encodedString = expand(openingBracketIndex , kIndex , i , encodedString);
                // TODO - This solution is not right.
                // So expansion is happening section by section and mutating the input
                // This expansion changes the index
                // So , i should change.
            }

            if (encodedArr[i] >= '0' && encodedArr[i] <= '9') {
                StringBuilder s = new StringBuilder();
                while(encodedArr[i] != '['){
                    s.append(encodedArr[i]);
                    i++;

                }
                kIndex.push(Integer.parseInt(String.valueOf(s)));
                openingBracketIndex.push(i);
            }

            i++;
        }
        System.out.println("decoded "+encodedString);
        return encodedString;
    }

    private String expand(Stack<Integer> openingBracketIndex, Stack<Integer> kIndex, int endingBracketIndex, String encodedString) {
        // get index of starting Index
        // substring starting to end Index
        // get no from stack
        // expand the substring according to the rule
        // take starting index of no according to no length
        // replace substring from starting index of no to closing index of ] with the expanded string
        Integer openingBracketCurrentIndex = openingBracketIndex.pop();
        int startingIndexOfString = openingBracketCurrentIndex + 1;
        String stringToExpand = encodedString.substring(startingIndexOfString , endingBracketIndex);
        int k = kIndex.pop();
        StringBuilder expandedString = new StringBuilder();
        for (int j = 0; j < k; j++) {
            expandedString.append(stringToExpand);
        }
        System.out.println("expandedString "+expandedString);
        int kLength = Integer.toString(k).length();
        int startingIndexOfStringToReplace  = openingBracketCurrentIndex - kLength;
        StringBuilder finalString = new StringBuilder();
        String startingString = encodedString.substring(0, startingIndexOfStringToReplace);
        String endString = encodedString.substring(endingBracketIndex+1);
        finalString.append(startingString);
        finalString.append(expandedString);
        finalString.append(endString);
        System.out.println("startingString "+startingString);
        System.out.println("expandedString "+expandedString);
        System.out.println("endString "+endString);
        return finalString.toString();

    }
}
