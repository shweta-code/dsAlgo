package com.algos.leetcode.graph;

import java.util.*;

// Coding Ninja - Alien Dictionary
// This solution might be right for coding Ninja as it assumes alphabets are just in diff order
// for the alien language but they belong to the same set given the same no
// means if alien lang has 3 alphabets , it will have a,b,c only in diff order
public class LeetCode269AlienDictionaryCodingNinja {

    static class Graph{

        ArrayList<Integer>[] neighbours;
        int numVertices;

        public Graph(int vertexCount) {
            this.numVertices = vertexCount;
            neighbours = new ArrayList[numVertices];
            for (int i = 0; i < numVertices; i++) {
                neighbours[i] = new ArrayList<>();
            }
        }

        public void addEdge(int src, int dest) {
            neighbours[src].add(dest);
        }

        public char[] topoSort() {
            boolean[] visited = new boolean[numVertices];
            Stack<Integer> completedVertices = new Stack<>();


            // Gettin the topoSort
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i]) {
                    dfs(i, visited, completedVertices);
                }
            }

            char[] arr = new char[numVertices];
            int curr = 0;
            while (!completedVertices.isEmpty()) {
                arr[curr++] = (char) ('a' + completedVertices.pop());
            }

            return arr;
        }

        public void dfs(int curr, boolean[] visited, Stack<Integer> completedVertices) {
            visited[curr] = true;

            for (int neighbour :
                    neighbours[curr]) {
                if (!visited[curr]) {
                    dfs(neighbour, visited, completedVertices);
                }
            }

            completedVertices.push(curr);
        }

    }

    public String alienOrder(String[] dict) {
        int n = dict.length;
        HashSet<Character> set = new HashSet<>();
        for (String word :
                dict) {
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
        }

        Graph graph = new Graph(26);

        for (int i = 0; i < n - 1; i++) {
            String currWord = dict[i];
            String nextWord = dict[i+1];

            int compareTill = Math.min(currWord.length(), nextWord.length());
            for (int j = 0; j < compareTill; j++) {
                if (nextWord.charAt(j) != currWord.charAt(j)) {
                    graph.addEdge(currWord.charAt(j) - 'a', nextWord.charAt(j));
                    break;
                }
            }
        }

        return Arrays.toString(graph.topoSort());

    }
}
