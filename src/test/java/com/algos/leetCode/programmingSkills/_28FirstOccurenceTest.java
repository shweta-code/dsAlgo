package com.algos.leetCode.programmingSkills;

import com.algos.leetcode.programmingSkills._28FirstOccurence;
import org.junit.Assert;
import org.junit.Test;

public class _28FirstOccurenceTest {

    private final _28FirstOccurence firstOccurence = new _28FirstOccurence();
    @Test
    public void test1() {
        int i = firstOccurence.strStr("sadbutsad", "sad");
        Assert.assertEquals(0, i);
    }
}
