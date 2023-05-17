package com.algos.leetCode.miscellaneous;

import com.algos.leetcode.miscellaneous.LeetCode359LoggerRateLimiter;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode359LoggerRateLimiterTest {

    private final LeetCode359LoggerRateLimiter rateLimiter = new LeetCode359LoggerRateLimiter();

    @Test
    public void test1() {

        Assert.assertTrue(rateLimiter.shouldPrintMessage(1, "foo"));
        Assert.assertTrue(rateLimiter.shouldPrintMessage(2, "bar"));
        Assert.assertFalse(rateLimiter.shouldPrintMessage(3, "bar"));
        Assert.assertFalse(rateLimiter.shouldPrintMessage(4, "bar"));
        Assert.assertFalse(rateLimiter.shouldPrintMessage(5, "bar"));
        Assert.assertFalse(rateLimiter.shouldPrintMessage(6, "bar"));

    }

    @Test
    public void test2() {
        Assert.assertTrue(rateLimiter.shouldPrintMessage(100, "bug"));
        Assert.assertTrue(rateLimiter.shouldPrintMessage(111, "bug"));
    }
}
