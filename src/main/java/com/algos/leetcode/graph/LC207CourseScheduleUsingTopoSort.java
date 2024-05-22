package com.algos.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC207CourseScheduleUsingTopoSort {

    public boolean canFinish(int numCourses, int[][] prerequisites){

        // prerequisistes is edge list
        // numCourses - V

        // calculate indegree of all vertices
        // put indegree 0 in q
        // iterate over q till it is empty
        // count through topo sort
        // if count != numCourses , it means there is a cycle

        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }


        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        // boolean[] visited = new boolean[numCourses];
        int countOfNodes = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                // visited[i] = true;
            }
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            countOfNodes++;
            // if (!visited[poll]) {
            List<Integer> adjNodes = adjList.get(poll);
            for (Integer adjNode : adjNodes) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
            // }

        }

        return countOfNodes == numCourses;

    }

}
