package com.algos.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC3_LongestSubstringWithoutRepeatingCharactersImpl implements ILC3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s){
        if (null != s && s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        // char[] sArr = s.toCharArray();
        int len = s.length();
        int strtPtr = 0;
        int endPtr;
        int maxLen = 0;


        Map<Character, Integer> map = new HashMap<>();

        // abcabcbb a a,3 1,3 |
        for(int i = 0; i < len; i++){

            char c = s.charAt(i);

            if(map.containsKey(c)){
                // System.out.println("j  " + j);

                // Should we remove chars?
                // Alternate way of doing so is
                /*for (int j = strtPtr; j < map.get(c); j++) {
                    System.out.println("Char at j "+ s.charAt(j));
                    map.remove(s.charAt(j));
                }*/

                if (map.get(c) >= strtPtr) {
                    strtPtr = map.get(c) +1;
                }

            }
            map.put(c, i);
            endPtr = i;
            maxLen = Math.max(maxLen, (endPtr - strtPtr) + 1);
        }

        return maxLen;
    }
}
