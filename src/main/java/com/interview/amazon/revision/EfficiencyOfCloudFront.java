package com.interview.amazon.revision;

import java.util.HashMap;
import java.util.Map;

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


    }

    public void findIndividualSets(int[][] edges, int n) {

        int[] graphs = new int[n];
        // fill above array with -1
        int noOfGraphs = 0;
        Map<Integer, Integer> edgeToSetMapping = new HashMap<>();
        // iterate through edges
        // vertex 1, vertex2
        // if vertex1 is visited && !vertex 2 is visited
        // put vertex2 value in vertex1
        // else if vertex1 is visited && !vertex 2 is visited
        // put vertex1 value in vertex2
        // else if !vertex1 and !vertex2 is visited
        // noOfGraphs
        // vertex1[] = noOfGraphs
        // else if vertex1 is visited && vertex 2 is visited
        // ignore
    }
}
