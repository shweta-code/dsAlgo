package com.algos.recurssion;

public class StringWithAdditiveSequence {

    public static void main(String[] args) {

        String input = "1991001991";
        boolean isAdditive = isAdditive(input);

    }

    public static boolean isAdditive(String input) {
        boolean isAdditive = Boolean.FALSE;
        for (int i = 1; i < (input.length() / 2); i++) {
            //int firstNum = Integer.parseInt(input.substring(0,i));
            for (int j = i + 1; j < input.length(); j++) {
                isAdditive = isAdditive(0, i, j, input);
                if (isAdditive) {
                    break;
                }

                /*int secondNum = Integer.parseInt(input.substring(i,j));
                int thirdNum = firstNum + secondNum;
                final String string = Integer.toString(thirdNum);
                int noOfDigitsInThirdNum = string.length();

                if(string.equals(input.substring(j , j+noOfDigitsInThirdNum))){
                    isAdditive = isAdditive(0, i , j, input);
                }*/

            }
            if (isAdditive) {
                break;
            }
        }

        return isAdditive;
    }

    private static boolean isAdditive(int firstNumStartIndex, int firstNumEndIndex, int secondNumEndIndex, String input) {
        if (secondNumEndIndex > input.length()) {
            return false;
        }
        if (secondNumEndIndex == input.length()) {
            return true;
        }
        int firstNum = Integer.parseInt(input.substring(firstNumStartIndex, firstNumEndIndex));
        int secondNum = Integer.parseInt(input.substring(firstNumEndIndex, secondNumEndIndex));
        int thirdNum = firstNum + secondNum;

        final String string = Integer.toString(thirdNum);
        int noOfDigitsInThirdNum = string.length();
        if (secondNumEndIndex + noOfDigitsInThirdNum > input.length()) {
            return false;
        }
        return string.equals(input.substring(secondNumEndIndex, secondNumEndIndex + noOfDigitsInThirdNum)) && isAdditive(firstNumEndIndex, secondNumEndIndex, secondNumEndIndex + noOfDigitsInThirdNum, input);

    }
}
