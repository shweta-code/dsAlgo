package com.algos.leetcode.set;

import java.util.HashSet;
import java.util.Set;

// Nice Solutions ->
// https://leetcode.com/problems/range-module/discuss/2261620/Java-oror-TreeMap-oror-Explained-in-Detail
// https://leetcode.com/problems/range-module/discuss/245463/Beat-100-Java-Binary-Search-Tree-implementation-short-and-concise
// https://leetcode.com/problems/range-module/discuss/1258449/Java-Merge-Split-Intervals
public class LeetCode715RangeModuleMemoryExceeded {

    Set<Integer> set = new HashSet<>();

    public LeetCode715RangeModuleMemoryExceeded() {

    }

    public void addRange(int left, int right) {
        for (int i = left; i < right; i++) {
            set.add(i);
        }
    }

    public boolean queryRange(int left, int right) {
        for (int i = left; i < right; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }

        return true;
    }

    public void removeRange(int left, int right) {
        for (int i = left; i < right; i++) {
            set.remove(i);
        }
    }

}
