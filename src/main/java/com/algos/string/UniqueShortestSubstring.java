package com.algos.string;

import java.util.*;

public class UniqueShortestSubstring {

    public static void main(String[] args) {
        String[] input = {"palantir","pelantors","cheapair","cheapoair"};

        // This is brute force
        // solutionOne(input);

        // This is the right solution
         //solution(Arrays.asList(input));


        // solution2(Arrays.asList(input));
        solution3(Arrays.asList(input));
    }

    private static void solutionOne(String[] input) {
        String[] ans = new String[input.length];

        System.arraycopy(input, 0, ans, 0, input.length);

        for (int index = 0; index < input.length; index++) {
            String current = input[index];
            int length = current.length();
            for(int i = 0 ; i < length; i++){
                for (int j = i+1; j <= length; j++) {
                    String subStr = current.substring(i,j);
                    boolean isUnique = false;
                    for (String str2 : input) {
                        if (str2.equals(current)) {
                            continue;
                        }
                        if (str2.contains(subStr)) {
                            isUnique = false;
                            break;
                        }
                        isUnique = true;
                    }
                    if(isUnique){
                        ans[index] = ans[index].length() < subStr.length() ? ans[index] : subStr;
                    }
                }
            }
        }

        System.out.println("ans -- "+Arrays.toString(ans));
    }

    public static Map<String, String> solution(List<String> input) {
        final TreeMap<String, Integer> map = new TreeMap<>((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());

        // {"palantir","pelantors","cheapair","cheapoair"}
        for (int i = 0; i < input.size(); ++i) // O(N)
        {
            // "palantir"
            // not thought out
            List<StringBuilder> suffix = new ArrayList<>();
            String current = input.get(i);
            for (int j = 0; j < current.length(); ++j) // O(L) //p,a,l,a,n,t,i,r
            {
                StringBuilder currentSuffix = new StringBuilder();
                currentSuffix.append(current.charAt(j)); //l
                if (map.containsKey(currentSuffix.toString())) {
                    map.put(currentSuffix.toString(), -1); // (p, 0),(a,0) (pa,0) (l,0)
                } else {
                    map.put(currentSuffix.toString(), i);
                }
                for (StringBuilder sb : suffix) { // O(L)
                    sb.append(current.charAt(j)); // pa
                    if (map.containsKey(sb.toString())) {
                        map.put(sb.toString(), -1);
                    } else {
                        map.put(sb.toString(), i);
                    }
                }
                suffix.add(currentSuffix); // "p","a",
            }
        }

        final Map<String, String> res = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == -1) continue;
            int idx = entry.getValue();
            res.putIfAbsent(input.get(idx), entry.getKey());
        }

        res.forEach((key, value) -> System.out.println(key + "   " + value));
        return res;
    }

    public static Map<String, String> solution2(List<String> input) {
        TreeMap<String, Integer> map = new TreeMap<>((o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());

        // {"palantir","pelantors","cheapair","cheapoair"}
        for(int i = 0 ; i < input.size(); i++){ // N
            List<StringBuilder> suffix = new ArrayList<>();
            String current = input.get(i);

            for(int j = 0 ; j < current.length(); j++){ // L
                String currentChar = String.valueOf(current.charAt(j));
                if(map.containsKey(currentChar)){
                    map.put(currentChar, -1);
                } else {
                    map.put(currentChar,i);
                }

                for(StringBuilder sb : suffix){ // L
                    sb.append(currentChar);
                    if(map.containsKey(sb.toString())){
                        map.put(sb.toString(), -1);
                    } else {
                        map.put(sb.toString(),i);
                    }

                }

                suffix.add(new StringBuilder(currentChar));
            }
        }

        Map<String, String> res = new HashMap<>();
        map.forEach((key, value) -> {
            if (value != -1) {
                res.putIfAbsent(input.get(value),key );
            }
        });

        res.forEach((key, value) -> System.out.println(key + "   " + value));

        return res;
    }

    public static Map<String, String> solution3(List<String> input) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            String current = input.get(i);
            System.out.println(current);
            for (int start = 0; start < current.length(); start++) {
                for (int end = start+1; end <= current.length(); end++) {
                    String sub = current.substring(start,end);
                    System.out.println(sub);
                    if (map.containsKey(sub)) {
                        map.put(sub, -1);
                    } else {
                        map.put(sub, i);
                    }
                }
            }

        }

        String[] ans = new String[input.size()];
        map.entrySet().forEach((entry) -> {
            if(entry.getValue() != -1){
                int index = entry.getValue();
                String smallestSub = entry.getKey();
                if(ans[index] == null || smallestSub.length() < ans[index].length() || (smallestSub.length() == ans[index].length() && input.get(index).indexOf(smallestSub) < input.get(index).indexOf(ans[index]))){
                    ans[index] = smallestSub;
                }

            }
        });

        // [al, s, apa, oa]
        System.out.println(Arrays.toString(ans));


        // format the string
        List<String> formattedList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String[] split = input.get(i).split(ans[i]);
            StringBuilder formattedStringBuilder = new StringBuilder();

            if ((ans[i] + split[0]).equals(input.get(i))){
                formattedStringBuilder.append("<u>");
                formattedStringBuilder.append(ans[i]);
                formattedStringBuilder.append("</u>");
                formattedStringBuilder.append(split[0]);
            } else if((split[0] + ans[i]).equals(input.get(i))){
                formattedStringBuilder.append(split[0]);
                formattedStringBuilder.append("<u>");
                formattedStringBuilder.append(ans[i]);
                formattedStringBuilder.append("</u>");
            } else if((split[0] + ans[i]+ split[1]).equals(input.get(i))) {
                formattedStringBuilder.append(split[0]);
                formattedStringBuilder.append("<u>");
                formattedStringBuilder.append(ans[i]);
                formattedStringBuilder.append("</u>");
                formattedStringBuilder.append(split[1]);
            } else if(ans[i].equals(input.get(i))){
                formattedStringBuilder.append("<u>");
                formattedStringBuilder.append(ans[i]);
                formattedStringBuilder.append("</u>");
            }
            formattedList.add(formattedStringBuilder.toString());
        }
        System.out.println(Arrays.toString(formattedList.toArray()));



        return new HashMap<>();



    }
}
