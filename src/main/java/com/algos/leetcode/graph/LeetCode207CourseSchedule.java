package com.algos.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode207CourseSchedule {

    // This problem is essentially checking if there is a
    // cycle in a directed graph. Each course can be represented as a node,
    // and each prerequisite relationship can be represented as a directed edge from the
    // prerequisite course to the target course.
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        // convert edge list into an adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }


        for (int[] prerequisiteRelationship : prerequisites) {
            adjList.get(prerequisiteRelationship[1]).add(prerequisiteRelationship[0]);
        }

        System.out.println(Arrays.toString(adjList.toArray()));
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycle(i, adjList, visited, recStack)) {
                    return false;
                }
            }
        }
        return true;


    }

    private boolean isCycle(int currNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] recStack) {
        if (recStack[currNode]) {
            return true;
        }

        if (visited[currNode]) {
            return false;
        }

        visited[currNode] = true;
        recStack[currNode] = true;
        for (Integer adjNode :
                adjList.get(currNode)) {
            if (isCycle(adjNode, adjList, visited, recStack)) {
                return true;
            }
        }
        recStack[currNode] = false;
        return false;
    }
}
