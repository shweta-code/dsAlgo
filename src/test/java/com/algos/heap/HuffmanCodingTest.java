package com.algos.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class HuffmanCodingTest {

    private  final HuffmanCoding HUFFMAN_CODING = new HuffmanCoding();

    @Test
    public void positive() throws Exception {
        Map<Character, String> codes = HUFFMAN_CODING.encode("aaaaaaaaaabcccccccccccccccddddddd");
        Assert.assertEquals(codes.get('a'), "11");
        Assert.assertEquals(codes.get('b'), "100");
        Assert.assertEquals(codes.get('c'), "0");
        Assert.assertEquals(codes.get('d'), "101");


    }

    @Test
    public void positiveTwo() throws Exception {
        Map<Character, String> codes = HUFFMAN_CODING.encode("ffffffaaaaabbbbcccdde");
        System.out.println(codes);
        Assert.assertEquals(codes.get('a'), "01");
        Assert.assertEquals(codes.get('b'), "00");
        Assert.assertEquals(codes.get('c'), "100");
        Assert.assertEquals(codes.get('d'), "1011");
        Assert.assertEquals(codes.get('e'), "1010");
        Assert.assertEquals(codes.get('f'), "11");


    }

    /*a:0
    b:1
    f:10
    c:110
    d:1110
    e:1111


    b:00
    a:01
    c:100
    e:1010
    d:1011
    f:11*/
}
