package com.algos.binarySearch;
/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104*/
public class SearchATwoDMatrix {

    public boolean findTarget (int[][] arr, int target) {
        int high = (arr.length * arr[0].length) - 1;
        int index = binarySearch(arr, 0 , high, target);
        System.out.println(" Answer " + index);
        if(index == -1){
            return false;
        } else {
            return true;
        }
    }

    private static int binarySearch(int[][] arr, int low, int high, int target) {

        if(arr.length == 0){
            return -1;
        }
        int rows = arr.length;
        int columns = arr[0].length;
        int length = (rows * columns);

        while( low <= high && low >=0 && high < length) {
            int mid = low + (high-low)/2;

            int row = mid / columns;
            int column = mid % columns;
            if(arr[row][column] == target) {
                return mid;

            } else if (arr[row][column]> target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }


}
