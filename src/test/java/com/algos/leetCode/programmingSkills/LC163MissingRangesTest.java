package com.algos.leetCode.programmingSkills;

import com.algos.leetcode.programmingSkills._163MissingRangesWrong;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LC163MissingRangesTest {

    private final _163MissingRangesWrong missingRanges = new _163MissingRangesWrong();

    @Test
    public void test1(){
        List<List<Integer>> missingRanges1 =
                missingRanges.findMissingRanges(new int[]{-1}, -1, -1);

        Assert.assertArrayEquals(new int[][]{}, missingRanges1.toArray());
    }

    @Test
    public void test2(){
        List<List<Integer>> missingRanges1 =
                missingRanges.findMissingRanges(new int[]{}, 1, 1);

        Assert.assertArrayEquals(new int[][]{}, missingRanges1.toArray());
    }

    @Test
    public void test3() {
        List<List<Integer>> missingRanges1 =
                missingRanges.findMissingRanges(new int[]{-1}, -2, -1);

        Assert.assertArrayEquals(new int[][]{{-2, -2}, {0,-1}}, missingRanges1.toArray());
    }

    @Test
    public void test4() {
        List<List<Integer>> missingRanges1 =
                missingRanges.findMissingRanges(new int[]{1, 2, 3, 4, 5}, 1, 5);

        Assert.assertArrayEquals(new int[][]{}, missingRanges1.toArray());
    }
}
