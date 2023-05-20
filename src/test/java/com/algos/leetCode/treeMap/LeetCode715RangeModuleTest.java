package com.algos.leetCode.treeMap;

import com.algos.leetcode.treeMap.LeetCode715RangeModule;
import org.junit.Test;

import java.util.TreeMap;

public class LeetCode715RangeModuleTest {

    private final LeetCode715RangeModule rangeModule = new LeetCode715RangeModule();

    @Test
    public void test1() {
        rangeModule.addRange(1, 10);
        rangeModule.removeRange(2, 8);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 10);
        treeMap.put(10, 17);
        treeMap.subMap(2, 10).clear();
        treeMap.forEach((key, value) -> System.out.println("key " + key + "value " + value));
    }
}
