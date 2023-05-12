package com.algos.leetCode.graph;

import com.algos.leetcode.graph.LeetCode269AlienDictionaryWrongII;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode269AlienDictionaryTest {

    LeetCode269AlienDictionaryWrongII alienDictionary = new LeetCode269AlienDictionaryWrongII();

    @Test
    public void test1() {
        String order = alienDictionary.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        Assert.assertEquals("wertf", order);


    }
}
