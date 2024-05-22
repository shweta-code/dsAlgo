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


    public int calculateEfficiency(int noOfNodes, int[][]  edgesList) {
        // We can use QuickFind algorithm
        // it will give us all roots
        // and for each root we can find no of nodes in graph
        QuickFind quickFind = new QuickFind(noOfNodes);
        for (int[] edges : edgesList) {
            // String[] s = string.split(" ");
            quickFind.union(edges[0], edges[1]);
        }
        // System.out.println(quickFind.findEfficiency());
        return (int) quickFind.findEfficiency();

    }

    static class QuickFind{
        private final int noOfNodes;
        private final int[] root;

        public QuickFind(int noOfNodes) {
            this.noOfNodes = noOfNodes;
            root = new int[noOfNodes];
            for (int i = 0; i < noOfNodes; i++) {
                root[i] = i;
            }
        }

        public int find(int x){
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            for (int i = 0; i < noOfNodes; i++) {
                if (root[i] == rootX) {
                    root[i] = rootY;
                }
            }
        }

        public double findEfficiency() {
            double eff = 0;
            Map<Integer, Integer> rootToCount = new HashMap<>();
            for (int i = 0; i < noOfNodes; i++) {
                rootToCount.put(root[i], rootToCount.getOrDefault(root[i], 0) + 1);
            }

            for (Integer value : rootToCount.values()) {
                eff += Math.sqrt(value);
            }

            return eff;
        }
    }
}
