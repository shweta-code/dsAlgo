package com.algos.dynamicProgramming;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PotsOfGoldGame {

    public static void main(String[] args) {

        String mydata = "above 15000";
        Pattern pattern = Pattern.compile("above ([0-9]+)");
        Matcher matcher = pattern.matcher(mydata);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        fromToSample();
    }

    private static void fromToSample() {
        String mydata = "rs 20000 to rs 15";
        Pattern pattern = Pattern.compile("rs ([0-9]+) to rs ([0-9]+)");
        Matcher matcher = pattern.matcher(mydata);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }
}
