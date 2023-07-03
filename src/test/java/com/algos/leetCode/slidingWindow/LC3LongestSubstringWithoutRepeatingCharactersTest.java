package com.algos.leetCode.slidingWindow;

import com.algos.leetcode.slidingWindow.ILC3_LongestSubstringWithoutRepeatingCharacters;
import com.algos.leetcode.slidingWindow.LC3_LongestSubstringWithoutRepeatingCharactersImpl;
import org.junit.Assert;
import org.junit.Test;

public class LC3LongestSubstringWithoutRepeatingCharactersTest {

    ILC3_LongestSubstringWithoutRepeatingCharacters solution = new LC3_LongestSubstringWithoutRepeatingCharactersImpl();

    @Test
    public void test1(){
        int len = solution.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, len);
    }

    @Test
    public void test2(){
        int len = solution.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(1, len);
    }

    @Test
    public void test3(){
        int len = solution.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, len);
    }

    @Test
    public void test4(){
        int len = solution.lengthOfLongestSubstring("p");
        Assert.assertEquals(1, len);
    }

    @Test
    public void test5(){
        int len = solution.lengthOfLongestSubstring("pt");
        Assert.assertEquals(2, len);
    }

    @Test
    public void test6(){
        int len = solution.lengthOfLongestSubstring("");
        Assert.assertEquals(0, len);
    }
}
