package com.algos.codeForces.slidingWindow;


import java.util.Scanner;

/*https://codeforces.com/contest/1354/problem/B*/
public class TernaryString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int noOfTextCases = sc.nextInt();
        for (int i = 0; i < noOfTextCases; i++) {
            String testCase = sc.next();
            System.out.println(findMinLengthOfContigousSubString(testCase   ));
        }
        //System.out.println(findMinLengthOfContigousSubString("333333"   ));

    }

    public static int findMinLengthOfContigousSubString(String input){
        char[] inputCharArr = input.toCharArray();
        boolean allPresent = false;
        int length = inputCharArr.length;
        int minLength = length;
        int[] indexArr = {-1, -1 , -1};
        for (int i = 0 ; i < length ; i++){
            indexArr[inputCharArr[i] - 1 - 48] = i ;
            if(!allPresent){
                boolean present = true;
                for (int j : indexArr){
                    present = present && (j != -1);
                    if(!present) {
                        break;
                    }
                }

                allPresent = present;
            }


            if(allPresent){
                int minIndex = length;
                int maxIndex = -1;
                for (int index : indexArr) {
                    if(index < minIndex)
                        minIndex = index;
                    if(index > maxIndex)
                        maxIndex = index;
                }

                int lengthOfSubString = maxIndex - minIndex +1;
                if( 3 == lengthOfSubString ){
                    return 3;
                } else if(lengthOfSubString < minLength){
                    minLength = lengthOfSubString;
                }
            }
        }
        if(!allPresent){
            return 0;
        }

        return minLength;
    }
}
