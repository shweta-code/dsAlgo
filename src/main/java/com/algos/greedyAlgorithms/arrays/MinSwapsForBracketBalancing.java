package com.algos.greedyAlgorithms.arrays;


/*


https://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/


* Minimum Swaps for Bracket Balancing
You are given a string of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string balanced.

Examples:

Input  : []][][
Output : 2
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]

Input  : [[][]]
Output : 0
String is already balanced.
*
*
* */

/*
Try doing it O(N) time and O(1) space
Link has a nice solution
*/

public class MinSwapsForBracketBalancing {

    public static void main(String[] args) {
        MinSwapsForBracketBalancing minSwapsForBracketBalancing = new MinSwapsForBracketBalancing();
        String input = "[]][][";
        System.out.println(minSwapsForBracketBalancing.bruteForce(input));
        System.out.println(minSwapsForBracketBalancing.bruteForce(input));
    }




    /*Time complexity = O(N^2)
    Space Complexity = O(N)*/
    public int bruteForce(String input) {
        int i = 0;
        int answer = 0;
        char[] arr = input.toCharArray();
        int n = arr.length;
        while (i < n) {
            if (arr[i] == 'V') {
                i++;
            } else if (arr[i] == '[') {

                for (int j = i + 1; j < n; j++) {
                    if (arr[j] == ']') {
                        arr[j] = 'V';
                        break;
                    }
                }
                i++;
            } else if (arr[i] == ']') {

                for (int j = i + 1; j < n; j++) {
                    if (arr[j] == '[') {
                        arr[j] = ']';
                        answer += j - i;
                        break;
                    }
                }
                i = i + 2;
            }


        }
        return answer;

    }


    /*Time complexity = O(N)
    Space Complexity = O(N)*/
    public int find(String input){
        char[] chars = input.toCharArray();
        int n = chars.length;
        int[] leftOpen = new int[n/2];
        int[] rightOpen = new int[n/2];
        int lo_index=0;
        int ro_index = 0;
        for (int i = 0; i < n; i++) {
            if(chars[i] == ']'){
                leftOpen[lo_index++] = i;
            } else {
                rightOpen[ro_index++] = i;
            }
        }

        int answer = 0;
        for (int lo = 0, ro=0 ; lo < leftOpen.length; lo++, ro++) {
            if(rightOpen[ro] > leftOpen[lo]){
                answer = rightOpen[ro] - leftOpen[lo];
                if(leftOpen[lo+1] < rightOpen[ro]){
                    leftOpen[lo+1] = rightOpen[ro];
                }
            }

        }

        return answer;

    }

}
