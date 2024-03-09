package com.interview.uber;

import java.util.*;

public class Problem {
  // Problem in Question.txt
  public static void main(String[] args) {
      String[][] data = new String[][]{
              {"Jamie","city1","1231321249"},
              {"Dana","city1","1231321248"},
              {"Jamie", "city2", "1231321245"},
              {"Jamie", "city3", "1231321248"},
              {"Dana", "city3", "1231321247"},
              {"Jamie", "city4", "1231321247"},
              {"Dana", "city4", "1231321245"},
      };


      Arrays.sort(data, new Comparator<String[]>() {
          @Override
          public int compare(String[] o1, String[] o2) {
              // basic type checks
              //look up standard compareTo function
              if(o1[0].compareTo(o2[0]) == 0){
                  return o1[2].compareTo(o2[2]);
              } else {
                  return o1[0].compareTo(o2[0]);
              }
          }
      });



      Map<String, Integer> triplets = new HashMap<>();
      // Aggregate
      for (int i = 0; i < data.length - 3; i++) {

          if (data[i][0].equals(data[i + 1][0]) && data[i + 1][0].equals(data[i + 2][0])) {
              // form a triplet
              // use delimiter to form triplets
              String triplet = data[i][1] + "-" + data[i + 1][1] + "-" + data[i + 2][1];

              triplets.put(triplet, triplets.getOrDefault(triplet, 0) + 1);
          } else {
              continue;
              // This is like a brute force
              // There is room for optimization
          }


      }

      for (Map.Entry<String, Integer> entry:
           triplets.entrySet()) {
          System.out.println(entry.getKey() + " "+ entry.getValue());
      }



  }
}