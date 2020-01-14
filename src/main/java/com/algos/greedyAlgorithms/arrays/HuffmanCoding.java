package com.algos.greedyAlgorithms.arrays;

public class HuffmanCoding {

    private static class HuffmanNode {
        private char data;
        public int frequency;
        public HuffmanNode left;
        public HuffmanNode Right;

        public HuffmanNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        String input = "aabc";
        encode(input);
    }

    private static void encode(String input) {
        char[] arr = input.toCharArray();

        for (char c : arr) {
            //HuffmanNode huffmanNode = new HuffmanNode();
        }


    }
}
