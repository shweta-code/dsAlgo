package com.algos.leetcode.graph;

import java.util.*;

// Premium - Not submitted yet
// https://leetcode.com/problemset/all/?search=Alien+dictionary&page=1
// https://www.codingninjas.com/codestudio/problems/alien-dictionary_630423

// This is wrong as this solution also tries to establish graph relationships within a word , kat does not mean k -> a -> t
// So , this is wrong
// A very clean solution is available in the below link
// TODO Solution -> https://www.codingninjas.com/codestudio/problems/alien-dictionary_630423?leftPanelTab=2
public class LeetCode269AlienDictionaryWrong {
    public static void main(String[] args) {

    }

    static class GraphNode {
        private final Character c;
        private final Set<GraphNode> adjNodes = new HashSet<>();

        public GraphNode(Character c) {
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GraphNode graphNode = (GraphNode) o;
            return Objects.equals(c, graphNode.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }

        public Character getC() {
            return c;
        }

        public Set<GraphNode> getAdjNodes() {
            return adjNodes;
        }
    }

    public static char[] getAlienLanguage(int n, String[] dictionary) {
        // Write your code here.

        // Algo
        // keep building map for unique characters and their adj nodes
        // Iterate dictionary and keep adding adjNodes
        // This way you will build the graph of nodes

        Map<Character, GraphNode> characterGraphNodeMap = buildGraph(n, dictionary);
        return toposort(characterGraphNodeMap);

    }

    private static char[] toposort(Map<Character, GraphNode> characterGraphNodeMap) {

        int noOfNodes = characterGraphNodeMap.size();


        int[] indegrees = new int[26];
        Arrays.fill(indegrees, -1);

        for (Character character :
                characterGraphNodeMap.keySet()) {
            indegrees[character - 'a'] = 0;
        }



        for (GraphNode graphNode :
                characterGraphNodeMap.values()) {
            for (GraphNode adjNode :
                    graphNode.getAdjNodes()) {
                indegrees[adjNode.getC() - 'a']++;
            }
        }



        System.out.println(Arrays.toString(indegrees));

        Queue<GraphNode> bfsQ = new LinkedList<>();


        for (int i = 0; i < indegrees.length; i++) {
            int indegree = indegrees[i];
            if (indegree == 0) {
                bfsQ.add(characterGraphNodeMap.get((char)(i+ 'a')));
                System.out.println("Added in queue "+ (char)(i+ 'a'));
            }
        }



        char[] topoSorted = new char[noOfNodes];
        int i = 0;
        while (!bfsQ.isEmpty()) {
            GraphNode node = bfsQ.peek();
            bfsQ.poll();
            topoSorted[i++] = node.getC();
            System.out.println(Arrays.toString(topoSorted));
            for (GraphNode adjNode :
                    node.getAdjNodes()) {

                if (--indegrees[adjNode.getC() - 'a'] == 0) {
                    bfsQ.add(adjNode);
                }
            }

        }

        return topoSorted;

    }

    private static Map<Character, GraphNode> buildGraph(int noOfWordsinDictionary, String[] dictionary) {
        Map<Character, GraphNode> charToNodeMap = new HashMap<>();
        for (int i = 0; i < noOfWordsinDictionary; i++) {
            // String word = dictionary[i];
            char[] currWordArr = dictionary[i].toCharArray();
            char currWordFirstChar = currWordArr[0];
            System.out.println(Arrays.toString(currWordArr));
            System.out.println("currWordFirstChar");
            System.out.println(currWordFirstChar);
            GraphNode firstCharGraphNode;
            if (!charToNodeMap.containsKey(currWordFirstChar)) {
                 firstCharGraphNode = new GraphNode(currWordFirstChar);
                charToNodeMap.put(currWordFirstChar, firstCharGraphNode);
            } else {
                firstCharGraphNode = charToNodeMap.get(currWordFirstChar);
            }

            for (int j = 1; j < currWordArr.length; j++) {

                Character currentChar = currWordArr[j];
                Character prevChar = currWordArr[j - 1];
                GraphNode currCharGraphNode;
                GraphNode prevCharGraphNode = charToNodeMap.get(prevChar);
                if (!charToNodeMap.containsKey(currentChar)) {
                    currCharGraphNode= new GraphNode(currentChar);
                    charToNodeMap.put(currentChar, currCharGraphNode);
                } else {
                    currCharGraphNode = charToNodeMap.get(currentChar);
                }

                // associate currentChar to prevChar
                if (prevChar != currentChar) {

                    prevCharGraphNode.getAdjNodes().add(currCharGraphNode);
                }

            }

            // associate current word to prev word
            if (i >= 1) {
                char[] prevWordArr = dictionary[i-1].toCharArray();
                char prevWordFirstChar = prevWordArr[0];
                GraphNode prevWordFirstCharGraphNode = charToNodeMap.get(prevWordFirstChar);
                if (prevWordFirstChar != currWordFirstChar) {

                    prevWordFirstCharGraphNode.getAdjNodes().add(firstCharGraphNode);
                }
            }

            printGraph(charToNodeMap);
            System.out.println();

        }

        return charToNodeMap;
    }

    public  static void printGraph(Map<Character, GraphNode> charToNodeMap) {
        charToNodeMap.forEach((key, value) -> {
            StringBuilder adjNodes = new StringBuilder();
            value.getAdjNodes().forEach(node -> adjNodes.append(node.getC()));
            String joined = String.join(",", adjNodes);
            System.out.println(key + "-> " + joined);
        });

    }
}
