package com.algos.leetcode.treeMap;

import java.util.Map;
import java.util.TreeMap;

public class LeetCode715RangeModule {

    TreeMap<Integer, Integer> treeMap;

    public LeetCode715RangeModule() {
        treeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> lFE = treeMap.floorEntry(left);
        Map.Entry<Integer, Integer> rFE = treeMap.floorEntry(right);
        if (lFE != null && lFE.getValue() >= left) {
            left = lFE.getKey();
        }

        if (rFE != null && rFE.getValue() >= right) {
            right = rFE.getValue();
        }

        treeMap.subMap(left, right).clear();
        treeMap.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        // leftFloorEntry
        Map.Entry<Integer, Integer> lFE = treeMap.floorEntry(left);

        return lFE != null && lFE.getValue() >= right;
    }

    public void removeRange(int left, int right) {

        Map.Entry<Integer, Integer> lFE = treeMap.floorEntry(left);
        Map.Entry<Integer, Integer> rFE = treeMap.floorEntry(right);

        if (lFE != null && lFE.getValue() >= left) {
            treeMap.put(lFE.getKey(), left);
        }

        if (rFE != null && rFE.getValue() > right) {
            treeMap.put(right, rFE.getValue());
        }

        treeMap.subMap(left, right).clear();
    }
}
