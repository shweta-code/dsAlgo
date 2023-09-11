package com.algos.leetCode.combinatorics;

import com.algos.leetcode.combinatorics._2514LeetCode;
import org.junit.Assert;
import org.junit.Test;

public class _2514LeetCodeTest {

    _2514LeetCode leetCodeTest = new _2514LeetCode();

    // Factorial Test
    @Test
    public void factorial(){
        long x= leetCodeTest.factorial(5);
        Assert.assertEquals(120, x);
    }
}
