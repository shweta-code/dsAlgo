package com.algos.leetcode.graph;

import java.util.Arrays;
import java.util.Comparator;

// Solution - Implement Union and Find algorithm
public class LC1101EarliestWhenEveryoneFriends {

    public int earliestAcq(int[][] logs, int n) {

        // Nice optimization
        // Taken from a comment in leetcode
        if (logs.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        System.out.println("base case -> "+Arrays.toString(parent));
        // Set<Integer> friends = new HashSet<>();

        Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));
        for (int[] log : logs) {
            int time = log[0];
            int friend1 = log[1];
            int friend2 = log[2];

            union(parent, friend1, friend2);
            System.out.println("edge -> "+ friend1 +" "+friend2);
            System.out.println(Arrays.toString(parent));

            if (isParentOfAllSame(parent, n)) {
                return time;
            }

        }

        return -1;
    }

    private boolean isParentOfAllSame(int[] parent, int n) {

        int baseParent = find(parent, 0);
        System.out.println("Base Parent-> "+ baseParent);
        for (int i = 0; i < n; i++) {
            int parentOfNode = find(parent, i);
            System.out.println("Parent of node ->"+ parentOfNode);
            if (parentOfNode != baseParent) {
                return false;
            }
        }
        return true;
    }

    private int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return find(parent, parent[node]);
    }

    private void union(int[] parent,int node1, int node2) {
        int parent1 = find(parent, node1);
        int parent2 = find(parent, node2);
        if (parent1 != parent2) {
            parent[parent1] = parent2;
        }
    }
}
