package com.algos.standards;

//Attempt 1 - No need for MaxWindow and having sum = n*Integer.MIN_VALUE
//brute force
public class FindMaxSumSubArray1 {

    public static void main(String[] args) {

    }
    public static long findMaxSumSubArray(int[] arr){

        int len = arr.length;
        MaxWindow maxWindow = new MaxWindow(len);
        for (int startIndex = 0; startIndex < len; startIndex++) {
            long sum = 0;
            for (int endIndex = startIndex; endIndex < len; endIndex++) {
                sum += arr[endIndex];
                System.out.println(sum);
                System.out.println(maxWindow.sum);
                if(sum > maxWindow.sum){
                    maxWindow.update(sum);

                }
            }
        }
        return maxWindow.sum;
    }
}

//brute force - little optimization
class FindMaxSumSubArray2 {


    public static long findMaxSumSubArray(int[] arr){

        int len = arr.length;
        long maxSumSoFar  = arr[0];;
        long currenSum = 0;
        for (int startIndex = 0; startIndex < len-1; startIndex++) {
            currenSum = arr[startIndex];
            for (int endIndex = startIndex+1; endIndex < len; endIndex++) {
                currenSum += arr[endIndex];

                if(currenSum > maxSumSoFar){
                    maxSumSoFar = currenSum;

                }
            }
        }
        return maxSumSoFar;
    }
}



//I thought it will be a sliding window problem.
/*My logoc for sliding window was:
To slide from left when sum < currentElement.
This will happen when a positive no is encountered with more negative as sum of all prev elements.
So window should be slid to this element. SInce it is not awindow per se.
        Therefore not a window problem*/


/*This is KADANE's algorithm*/

class FindMaxSumSubArray3 {


    public static long findMaxSumSubArray(int[] arr){

        
        int len = arr.length;
        if(len == 0 ){
            
            return 0;
        }
        long currSum = arr[0];
        long maxSumSoFar = arr[0];
        for (int i = 1; i < len; i++) {
            currSum = Math.max(arr[i], currSum+arr[i]);
            maxSumSoFar = Math.max(maxSumSoFar, currSum);
        }

        return maxSumSoFar;
    }
}


class MaxWindow{


    public long sum ;

    public MaxWindow(int n) {
        long minValue = Integer.MIN_VALUE;
        sum = n * minValue;
    }

    public void update(long sum){
        this.sum = sum;

    }
}
