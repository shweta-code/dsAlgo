package com.algos.string;

import org.junit.Assert;
import org.junit.Test;

public class DecodeString_LeetCode394Test {
    DecodeString_LeetCode394 testClass = new DecodeString_LeetCode394();

    @Test
    public void emptyInput(){
        Assert.assertEquals("",testClass.decodeString("") );
    }

    @Test
    public void flattenedInput(){
        Assert.assertEquals("aabbb",testClass.decodeString("2[a]3[b]") );
    }

    @Test
    public void deepInput(){
        Assert.assertEquals("abbccabbcc",testClass.decodeString("2[a2[b]2[c]]") );
    }

    @Test
    public void multiLevelInput(){
        Assert.assertEquals("aabccbccbccbcc",testClass.decodeString("2[a2[b2[c]]]") );
    }

    @Test
    public void multiIntegerInput(){
        Assert.assertEquals("abbabbabbabbabbabbabbabbabbabb",testClass.decodeString("10[a2[b]]") );
    }

    @Test
    public void oneInIntegerInput(){
        Assert.assertEquals("abb",testClass.decodeString("1[a2[b]]]") );
    }
    @Test
    public void compositeInput(){
        Assert.assertEquals("abcee",testClass.decodeString("abc2[e]") );
        Assert.assertEquals("abcabccdcdcdef",testClass.decodeString("2[abc]3[cd]ef") );
        Assert.assertEquals("abccdcdcdxyz",testClass.decodeString("abc3[cd]xyz") );
    }

}
