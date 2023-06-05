package com.algos.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    // The trick is to have empty node at head and ' ' at end of each word
    private final TrieNode head;

    public Trie() {
        head = TrieNode.emptyTrieNode();
    }

    public void insert(String word) {

        // iterate through arr - foreach
        // unflod head and find if char is there
        // if you keep finding char kep changing nodeToNext

        // post that start creating node

        char[] wordCharArray = word.toCharArray();
        TrieNode node = head;
        int i = 0;
        int length = wordCharArray.length;
        while ( i < length) {
            if (node.trieNodes.containsKey(wordCharArray[i])) {
                node = node.trieNodes.get(wordCharArray[i]);
            } else {
                break;
            }
            ++i;
        }

        for (int j = i; j < length; j++) {
            char c = wordCharArray[j];
            TrieNode trieNode = new TrieNode(c);
            node.addNode(c, trieNode);
            node = trieNode;
        }
        node.addNode(' ', TrieNode.emptyTrieNode());
    }

    public boolean search(String word) {
        char[] wordCharArray = word.toCharArray();
        TrieNode node = head;
        int i = 0;
        int length = wordCharArray.length;
        while ( i < length) {
            if (node.trieNodes.containsKey(wordCharArray[i])) {
                node = node.trieNodes.get(wordCharArray[i]);
                ++i;
            } else {
                break;
            }
        }
        return i == length && node.trieNodes.containsKey(' ');
    }

    public boolean startsWith(String prefix) {
        char[] prefixCharArray = prefix.toCharArray();
        TrieNode node = head;
        int i = 0;
        int length = prefixCharArray.length;
        while ( i < length) {
            if (node.trieNodes.containsKey(prefixCharArray[i])) {
                node = node.trieNodes.get(prefixCharArray[i]);
                ++i;
            } else {
                break;
            }

        }
        return i == length;
    }

    static class  TrieNode {

        private final char val;
        private final Map<Character,TrieNode> trieNodes;

        public TrieNode(char val) {
            this.val = val;
            this.trieNodes = new HashMap<>();
        }

        public static TrieNode emptyTrieNode() {
            return new TrieNode(' ');
        }

        public void addNode(Character c, TrieNode trieNode) {
            trieNodes.put(c, trieNode);
        }

    }

}
