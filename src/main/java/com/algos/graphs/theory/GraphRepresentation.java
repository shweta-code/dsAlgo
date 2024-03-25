package com.algos.graphs.theory;

// Types oF Graph -> https://www.tutorialspoint.com/types-of-graph
public class GraphRepresentation {
    public static void main(String[] args) {
        // Undirected Graph
        // 1 -- 2
        // |    |
        // 3 -- 4

        // For a completely connected graph of 4 nodes, no of edges will be = nC2

        // Edge List
        // No of entries in list = no of edges
        // {{1,2}, {1,3}, {2,4}, {4,3}}
        // Con of using Array will be it cannot be dynamically increased ,
        // no edge cannot be added at runtime
        int[][] edgeList = new int[4][2];
        edgeList[0] = new int[] {1,2};
        edgeList[1] = new int[] {1,3};
        edgeList[2] = new int[] {2,4};
        edgeList[3] = new int[] {4,3};

        printEdgeList(edgeList);


        // AdjacencyList
        // {{2,3}, {1,4}, {1,4}, {2,3}}
        // ArrayList<ArrayList<Integer> > adj

        // AdjacencyMatrix
        // int[][] adjacencyMatrix = new int[][];
        // {{0, 1, 1, 0}, {1, 0, 0, 1}, {1, 0, 0, 1}, {0, 1, 1, 0}}



        //Directed Graph
    }

    private static void printEdgeList(int[][] edgeList) {
        for (int[] ints : edgeList) {
            for (int edge : ints) {
                System.out.println(edge);
            }
        }
    }


}
