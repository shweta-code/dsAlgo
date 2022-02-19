package com.algos.binarySearch;

/*There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
*/

public class SearchInRotatedSortedArr {
    private int pivot;
    private int arrLength;
    public int findTarget (int[] arr, int target) {
        this.pivot = computePivot(arr, 0 , arr.length - 1);
        System.out.println("Pivot " + pivot);
        this.arrLength = arr.length;
        int index = binarySearch(arr, 0 , arr.length-1, target, this.pivot);
        System.out.println(" Answer " + index);
        return index;
    }

    private int computePivot(int[] arr, int low, int high) {
        while(low <= high && low >=0 && high < arr.length) {
            int mid = low + (high-low)/2;

            if( mid -1 >=0 && arr[mid] < arr[mid -1]){
                return mid;
            } else if(mid - low == 1 && arr[mid] < arr[low]) {
                return mid;
            }else if(arr[mid] < arr[low]) {
                high = mid - 1;
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                return low;
            }
        }
        return 0;
    }

    private int binarySearch(int[] arr, int low, int high, int target, int pivot) {


        while( low <= high && low >=0 && high < arr.length) {
            int mid = low + ((high-low)/2);

            if(arr[pivotedIndex(mid)] == target) {
                return pivotedIndex(mid);

            } else if (arr[pivotedIndex(mid)]> target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

    private int pivotedIndex(int index) {
        return (index+this.pivot)%arrLength;
    }

}
