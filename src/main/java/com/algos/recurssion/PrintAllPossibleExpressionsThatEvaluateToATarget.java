package com.algos.recurssion;


public class PrintAllPossibleExpressionsThatEvaluateToATarget {

    public static void main(String[] args) {

        String input = "125";
        int target = 125;
        findExpressions(input, target, 0, "", 0, 0);

    }

    private static void findExpressions(String input, int target, int index, String expression, int result, int last) {


        if (result == target) {
            System.out.println(expression);
        }
        if (index == input.length()) {
            return;
        }

        for (int i = index; i < input.length(); i++) {
            String part = input.substring(index, i + 1);

            int current = Integer.valueOf(part);
            if (index == 0) {
                findExpressions(input, target, i + 1, String.valueOf(current), current, current);
            } else {
                findExpressions(input, target, i + 1, expression + "+" + part, result + current, current);
                findExpressions(input, target, i + 1, expression + "-" + part, result - current, -current);
                findExpressions(input, target, i + 1, expression + "*" + part, result - last + last * current, last * current);
            }

        }
    }
}
