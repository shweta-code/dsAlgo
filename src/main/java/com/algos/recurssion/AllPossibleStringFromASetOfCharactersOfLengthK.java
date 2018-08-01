package com.algos.recurssion;

import java.util.ArrayList;
import java.util.List;


public class AllPossibleStringFromASetOfCharactersOfLengthK {

    public static void main(String[] args) {
        AllPossibleStringFromASetOfCharactersOfLengthK allPossibleStringFromASetOfCharactersOfLengthK = new AllPossibleStringFromASetOfCharactersOfLengthK();
        String[] input = {"a", "b", "c"};
        int k = 3;
        List<String[]> list = allPossibleStringFromASetOfCharactersOfLengthK.generate1(input, k);
        for (String[] strings : list) {
            StringBuilder s = new StringBuilder();
            for (String string : strings) {
                s.append(string);
            }
            System.out.println(s);
        }
    }

    private List<String> generate(String[] input, int k) {

        List<String> list = new ArrayList<>();
        String[] arr = new String[100];
        int index = 0;
        int newIndex;
        for (int i = 0; i < k; i++) {
            if (index == 0) {
                for (String s : input) {
                    arr[index++] = s;
                    //index++;
                }
            } else {
                newIndex = index;
                for (int j = 0; j < newIndex; j++) {

                    for (String s : input) {
                        arr[index++] = arr[j] + s;
                    }
                }
                //index = newIndex;
            }
        }
        for (String s : arr) {
            System.out.println(s);
        }

        return list;

    }

    private List<String[]> generate1(String[] input, int k) {
        int n = input.length;
        double x = Math.pow(n, k);
        List<String[]> list = new ArrayList<>((int) x);
        for (int i = 0; i < x; i++) {
            list.add(new String[k]);
        }
        for (int i = 1; i <= k; i++) {
            int index = 0;
            int s = (int) Math.pow(n, i - 1);
            for (int repeat = 0; repeat < s; repeat++) {
                for (String character : input) {
                    int y = (int) Math.pow(n, k - i);
                    for (int j = 0; j < y; j++) {
                        String[] wordOfLengThK = list.get(index++);
                        wordOfLengThK[i - 1] = character;
                    }
                }
            }

        }
        return list;
    }
}
