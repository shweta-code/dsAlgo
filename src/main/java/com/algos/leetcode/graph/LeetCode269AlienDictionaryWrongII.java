package com.algos.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class LeetCode269AlienDictionaryWrongII {

    static class Graph{

        ArrayList<Integer>[] neighbours;
        int numVertices = 26;

        public Graph(int vertexCount) {
            this.numVertices = 26;
            int totalAlphabets = 26;
            neighbours = new ArrayList[totalAlphabets];
            for (int i = 0; i < totalAlphabets; i++) {
                neighbours[i] = new ArrayList<>();
            }
        }

        public void print() {
            for (int i = 0; i < 26; i++) {
                String adjNode = Arrays.toString(neighbours[i].toArray());
                System.out.println((char)(i + 'a') + " -> " + adjNode);
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
                if (!visited[i] && !neighbours[i].isEmpty()) {
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

        int uniqueCharacters = set.size();
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

        graph.print();
        return Arrays.toString(graph.topoSort());

    }
}
