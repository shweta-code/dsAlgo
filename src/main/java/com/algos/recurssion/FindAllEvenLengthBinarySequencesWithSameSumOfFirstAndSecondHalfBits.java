package com.algos.recurssion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindAllEvenLengthBinarySequencesWithSameSumOfFirstAndSecondHalfBits {

    public static void main(String[] args) {
        int input = 3;
        for (int sum = 0; sum <= 3; sum++) {
            String str = "";
            Set<String> set = new HashSet<>();
            if (sum == 1) {
                System.out.println();
            }

            find(sum, set, str, input, 0);
            find(sum, set, str, input, 1);

            ArrayList<String> strings = new ArrayList<>(set);
            System.out.println("sum " + sum);
            System.out.println(set);
            for (int j = 0; j < strings.size(); j++) {
                for (int k = j; k < strings.size(); k++) {
                    System.out.println(strings.get(j) + strings.get(k));
                }
            }
        }

    }

    private static void find(int sum, Set<String> set, String str, int input, int i) {
        String nwString = str + i;
        sum = sum - i;
        if (sum == 0 && nwString.length() == input) {
            set.add(nwString);
        } else if (sum < 0) {
            return;
        } else if (nwString.length() > input) {
            return;
        } else {
            find(sum, set, nwString, input, 0);
            find(sum, set, nwString, input, 1);
        }

    }
}
