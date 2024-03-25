package com.interview.amazon;

import java.util.*;


// I am not sure why I am sorting
// May be this can be done using disjoint set
public class EfficiencyOfCloudFront {

      /*Given n nodes and list of edges (integers separated by space) in a graph, you have to find
        an efficiency number that is sum of Math.sqrt(no of nodes in an isolated set)
        For ex : In an input like
            no of nodes - 10
            edges - [[10 9],[1 2],[8 5],[2 4],[7 5],[ 4 6]] - These edges will be separated by space (" ")
            4 isolated sets are there  [9,10][1,2,4,6][8,7,5][3]
            efficiency no = Math.sqrt(4) + Math.sqrt(2)+ Math.sqrt(3) + Math.sqrt(1)
        */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("10 9");
        list.add("1 2");
        list.add("8 5");
        list.add("2 4");
        list.add("7 5");
        list.add("4 6");
        calculateEfficiency(10, list);
    }

    private static int calculateEfficiency(int noOfNodes, List<String> edgesList) {
        List<List<Integer>> edges = new ArrayList<>();
        for (String s : edgesList) {
            String[] edgesArr = s.split(" ");
            final int edge1 = Integer.parseInt(edgesArr[0]);
            final int edge2 = Integer.parseInt(edgesArr[1]);
            List<Integer> integers = Arrays.asList(edge1, edge2);
            integers.sort(Comparator.naturalOrder());
            edges.add(integers);
        }

        edges.sort(Comparator.comparingInt(edge -> edge.get(0)));
        System.out.println(Arrays.toString(edges.toArray()));
        
        int set = -1;
        int[] verticesSetInfo = new int[noOfNodes];
        Arrays.fill(verticesSetInfo, -1);
        for (List<Integer> edge : edges) {
            if(verticesSetInfo[edge.get(0)-1] != -1){
                verticesSetInfo[edge.get(1)-1] = verticesSetInfo[edge.get(0)-1];
            } else {
                verticesSetInfo[edge.get(0)-1] = (++set);
                verticesSetInfo[edge.get(1)-1] = set;

            }
        }
        System.out.println(Arrays.toString(verticesSetInfo));
        int[] verticesInIsolatedSet = new int[set+1];
        int singleVertexSetCount = 0;
        for (int j : verticesSetInfo) {
            if (j == -1) {
                singleVertexSetCount++;
            } else {
                verticesInIsolatedSet[j]++;
            }
        }
        System.out.println(Arrays.toString(verticesInIsolatedSet));
        int efficieny = 0;
        efficieny += singleVertexSetCount;
        for (int i : verticesInIsolatedSet) {
            efficieny += (int) Math.sqrt(i);
        }
        return efficieny;












    }


}
