package com.algos.leetcode.programmingSkills;

import java.util.ArrayList;
import java.util.List;

public class _163MissingRangesWrong {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {



        int i = 0;
        int len = nums.length;
        int j = lower;
        List<List<Integer>> missingRanges = new ArrayList<>();

        if (len == 0) {
            List<Integer> missingRange = new ArrayList<>();
            missingRange.add(lower);
            missingRange.add(upper);
            missingRanges.add(missingRange);
            return missingRanges;
        }

        while(i < len && j <= nums[len-1] && j< upper){

            if(nums[i] == j){
                i++;
                j++;
            }

            else if(j < nums[i]){
                List<Integer> missingRange = new ArrayList<>();
                missingRange.add(j);
                missingRange.add(nums[i]-1);
                missingRanges.add(missingRange);
                j = nums[i]+1;
                i++;
            }


        }

        if(j < upper){
            List<Integer> missingRange = new ArrayList<>();
            missingRange.add(j);
            missingRange.add(upper);
            missingRanges.add(missingRange);
        }

        return missingRanges;
    }
}
