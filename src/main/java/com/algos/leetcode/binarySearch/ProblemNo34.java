package com.algos.leetcode.binarySearch;

import java.util.Arrays;

/*Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109*/
public class ProblemNo34 {

    public static void main(String[] args) {
        int[] arr = {5,7,8,8,10};

    }

    // Thought for food - Scale binary search for an array larger than that can be stored on disk
    public int[] findTarget (int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        ans = binarySearch(arr, 0 , arr.length-1, target, ans);
        System.out.println(" Answer " +Arrays.toString(ans));
        return ans;
    }
    private static int[] binarySearch(int[] arr, int low, int high, int target, int[] ans) {

        if (low > high) {
            System.out.println(" Terminating "+Arrays.toString(ans));
            return ans;
        }
        int[] arrFromLeft = ans;
        int[] arrFromRight = ans;

        while( low <= high && low >=0 && high < arr.length) {
            int mid = low + (high-low)/2;

            if(arr[mid] == target) {
                System.out.println(" Found target ");
                if(ans[0] == -1) {
                    ans[0] = mid;
                    ans[1] = mid;
                    arrFromLeft = binarySearch(arr, low,mid-1, target, ans);
                    arrFromRight = binarySearch(arr,mid+1, high, target, ans);
                    System.out.println(Arrays.toString(arrFromLeft));
                    System.out.println(Arrays.toString(arrFromRight));
                }

                if( ans[0] != -1 && ans[0] > mid ){
                    ans[0] = mid;
                    arrFromLeft = binarySearch(arr, low, mid-1 , target, ans);
                }
                if( ans[1] != -1 && ans[1] < mid ){
                    ans[1] = mid;
                    arrFromRight = binarySearch(arr, mid+1, high , target, ans);
                }

                return new int[] {Math.min(arrFromLeft[0], arrFromRight[0]), Math.max(arrFromLeft[1], arrFromRight[1])};
            } else if (arr[mid]> target) {
                System.out.println(" arr[mid]> target " + arr[mid] + " "+ target );
                high = mid - 1;
            } else {
                System.out.println(" arr[mid]< target " + arr[mid] + " "+ target );
                low = mid + 1;
            }

        }
        System.out.println(" Did not find anything ");
        return ans;
    }

}
