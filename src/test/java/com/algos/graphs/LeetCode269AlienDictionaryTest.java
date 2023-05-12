package com.algos.graphs;

import com.algos.leetcode.graph.LeetCode269AlienDictionaryWrong;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode269AlienDictionaryTest {

    @Test
    public void testSimple() {
        char[] alienLanguage = LeetCode269AlienDictionaryWrong.getAlienLanguage(2, new String[]{"a", "b"});
        Assert.assertArrayEquals(new char[]{'a', 'b'}, alienLanguage);
    }

    @Test
    public void testSimpleThreeWords() {
        char[] alienLanguage = LeetCode269AlienDictionaryWrong.getAlienLanguage(3, new String[]{"a", "b", "c"});
        Assert.assertArrayEquals(new char[]{'a', 'b', 'c'}, alienLanguage);
    }

    @Test
    public void testSingleAlphLang() {
        char[] alienLanguage = LeetCode269AlienDictionaryWrong.getAlienLanguage(3, new String[]{"a", "aa", "aaa"});
        Assert.assertArrayEquals(new char[]{'a'}, alienLanguage);
    }

    @Test
    public void testCase1() {
        char[] alienLanguage = LeetCode269AlienDictionaryWrong.getAlienLanguage(1, new String[]{"aa"});
        Assert.assertArrayEquals(new char[]{'a'}, alienLanguage);
    }

    @Test
    public void testCase2() {
        char[] alienLanguage = LeetCode269AlienDictionaryWrong.getAlienLanguage(2, new String[]{"aaa", "aaa"});
        Assert.assertArrayEquals(new char[]{'a'}, alienLanguage);
    }

    @Test
    public void testCase3() {
        char[] alienLanguage = LeetCode269AlienDictionaryWrong.getAlienLanguage(3, new String[]{"caa", "aaa", "aab"});
        Assert.assertArrayEquals(new char[]{'c','a', 'b'}, alienLanguage);
    }

    @Test
    public void testCase4() {
        char[] alienLanguage = LeetCode269AlienDictionaryWrong.getAlienLanguage(3, new String[]{ "aaa", "aab", "aac", "aad"});
        Assert.assertArrayEquals(new char[]{'a', 'b', 'c', 'd'}, alienLanguage);
    }
}
