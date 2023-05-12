package com.algos.graphs;

import com.algos.leetcode.graph.LeetCode953VerifyAlienDict;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode953VerifyAlienDictTest {

    LeetCode953VerifyAlienDict verifyAlienDict = new LeetCode953VerifyAlienDict();

    @Test
    public void basicTest() {
        boolean sorted = verifyAlienDict.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz");
        Assert.assertFalse(sorted);
    }

    @Test
    public void prevWordGreaterLengthTest() {
        boolean sorted = verifyAlienDict.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz");
        Assert.assertFalse(sorted);
    }

    @Test
    public void sameWordsTest() {
        boolean sorted = verifyAlienDict.isAlienSorted(new String[]{"hello", "hello"}, "abcdefghijklmnopqrstuvwxyz");
        Assert.assertTrue(sorted);
    }
}
