package com.algos.leetcode.graph;

import java.util.*;

// Hint - Basically this question's answer is topological sort with cycle detection
// The solution here is a combination of Topology sort and cycle detection
// One more elegant solution can be Kahn's algorithm - https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
public class LeetCode210CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        List<Integer> recStack = new ArrayList<>();
        boolean[] recStackFlag = new boolean[numCourses];
        // convert edge list into an adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }


        for (int[] prerequisiteRelationship : prerequisites) {
            adjList.get(prerequisiteRelationship[1]).add(prerequisiteRelationship[0]);
        }

        System.out.println(Arrays.toString(adjList.toArray()));
        ArrayList<Integer> nodesWithIndegreeZero = new ArrayList<>();

        int[] indegree = new int[numCourses];
        for (ArrayList<Integer> adjNodes : adjList) {
            for (int adjNode :
                    adjNodes) {
                indegree[adjNode]++;
            }
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                nodesWithIndegreeZero.add(i);
            }
        }

        if (nodesWithIndegreeZero.isEmpty()) {
            return new int[]{};
        }

        System.out.println(Arrays.toString(nodesWithIndegreeZero.toArray()));
        for (Integer nodeWithIndegreeZero : nodesWithIndegreeZero) {
            try {
                toposort(nodeWithIndegreeZero, adjList, visited, recStack, recStackFlag);
            } catch (IllegalArgumentException e) {
                return new int[]{};
            }
        }

        // test case - testthreeDisconnectedGraphsWhereOneisCyclic
        if (recStack.size() != numCourses) {
            return new int[]{};
        }

        Collections.reverse(recStack);
        return recStack.stream().mapToInt(Integer::intValue).toArray();
    }

    private void toposort(int currNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, List<Integer> recStack, boolean[] recStackFlag) {
        // Revise - How to terminate recurssion - return a magic value or throw Exception
        if (recStackFlag[currNode]) {
            System.out.println("Exception thrown");
            throw new IllegalArgumentException();
        }

        // test case - testTwoNodesCyclic
       if (visited[currNode]) {
            return;
       }

        visited[currNode] = true;
        recStackFlag[currNode] = true;

        // recStack.add(currNode);
        for (Integer adjNode :
                adjList.get(currNode)) {
            // if (!visited[adjNode]) {
                toposort(adjNode, adjList, visited, recStack, recStackFlag);
            // }
        }

        recStack.add(currNode);
        recStackFlag[currNode] = false;
    }
}
