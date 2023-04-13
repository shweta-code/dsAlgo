package com.algos.leetcode.graph;

import java.util.Arrays;

public class LeetCode547NoOfProvinces {

    public int findCircleNumNotWorking(int[][] isConnected) {

        int noOfCities = isConnected.length;
        boolean[] visited = new boolean[noOfCities];
        int noOfProvinces = 0;

        // This solution is wrong as it assumes the cities in province
        // are connected serially
        for (int i = 0; i < noOfCities; i++) {
            for (int j = 0; j < noOfCities; j++) {
                if (isConnected[i][j] == 1) {
                    if (!visited[i]) {
                        noOfProvinces++;
                    }
                    visited[j] = true;
                }
                System.out.println(Arrays.toString(visited));
            }
        }

        return noOfProvinces;
    }

    // Time complexity - O(V)
    // Space complexity - O(V)
    public int findCircleNum(int[][] isConnected) {

        int noOfCities = isConnected.length;
        boolean[] visited = new boolean[noOfCities];
        int noOfProvinces = 0;

        // This solution is wrong as it assumes the cities in province
        // are connected serially
        for (int i = 0; i < noOfCities; i++) {
            if (!visited[i]) {
                traverse(i, visited, isConnected);
                noOfProvinces += 1;
            }
        }

        return noOfProvinces;
    }

    private void traverse(int cityNo, boolean[] visited, int[][] isConnected) {
        visited[cityNo] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[cityNo][j] == 1) {
                if (cityNo != j && !visited[j]) {
                    traverse(j, visited, isConnected);
                }
            }
        }
        // return 1;
    }
}
