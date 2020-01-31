package com.algos.heap;

import com.algos.heap.MinHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/*
* @miniTest
* Write pseudoCode for huffmanCoding
*
* */
public class HuffmanCoding {

    private static class HuffmanNode implements Comparable<HuffmanNode>{
        private char data;
        private int frequency;
        private HuffmanNode left;
        private HuffmanNode Right;

        public HuffmanNode(char data) {
            this.data = data;
            this.frequency = 1;
            this.left = null;
            this.setRight(null);
        }

        public HuffmanNode(char data, int frequency, HuffmanNode left, HuffmanNode right) {
            this.data = data;
            this.frequency = frequency;
            this.left = left;
            Right = right;
        }

        @Override
        public int compareTo(HuffmanNode o) {
            return Integer.compare(this.frequency, o.frequency);
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public HuffmanNode getLeft() {
            return left;
        }

        public void setLeft(HuffmanNode left) {
            this.left = left;
        }

        public HuffmanNode getRight() {
            return Right;
        }

        public void setRight(HuffmanNode right) {
            Right = right;
        }
    }

    public static void main(String[] args) throws Exception {
        String input = "ffffffaaaaabbbbcccdde";
        System.out.println(encode(input));;
    }

    public static Map<Character, String> encode(String input) throws Exception {
        char[] arr = input.toCharArray();

        Map<Character, HuffmanNode> nodesMap = getCharacterHuffmanNodeMap(arr);

        System.out.println(nodesMap);
        MinHeap<HuffmanNode> minHeap = getHuffmanNodeMinHeap(arr, nodesMap);

        process(minHeap);

        Map<Character, String> charToCode = new HashMap();
        encode(minHeap.get(0), charToCode , "");
        return charToCode;

    }

    private static void process(MinHeap<HuffmanNode> minHeap) throws Exception {
        while(minHeap.size() > 1){
            HuffmanNode smallest = minHeap.extractMin();
            HuffmanNode secondSmallest = minHeap.extractMin();
            HuffmanNode node = new HuffmanNode('-', smallest.getFrequency()+secondSmallest.getFrequency() , smallest, secondSmallest);
            minHeap.insert(node);
        }
    }

    private static MinHeap<HuffmanNode> getHuffmanNodeMinHeap(char[] arr, Map<Character, HuffmanNode> nodesMap) throws Exception {
        MinHeap<HuffmanNode> minHeap = new MinHeap<>(arr.length);
        for (HuffmanNode value : nodesMap.values()) {
            minHeap.insert(value);
        }
        return minHeap;
    }

    private static Map<Character, HuffmanNode> getCharacterHuffmanNodeMap(char[] arr) {
        Map<Character, HuffmanNode> nodesMap = new HashMap<>();
        for (char c : arr) {
            HuffmanNode huffmanNode = nodesMap.get(c);
            if(null != huffmanNode){
                huffmanNode.setFrequency(huffmanNode.getFrequency()+1);
            } else {
                HuffmanNode node = new HuffmanNode(c);
                nodesMap.put(c, node);
            }
        }
        return nodesMap;
    }

    private static void encode(HuffmanNode huffmanNode, Map<Character, String> charToCode, String code) {
         if(Character.isAlphabetic((huffmanNode.getData())) && Objects.isNull(huffmanNode.getLeft()) && Objects.isNull(huffmanNode.getRight())){
            charToCode.put(huffmanNode.getData() , code);
         } else {
             encode(huffmanNode.getLeft(), charToCode, code + "0");
             encode(huffmanNode.getRight(), charToCode, code + "1");
         }
    }

    /*a:0
    b:100
    f:101
    c:110
    e:1110
    d:1111*/





}
