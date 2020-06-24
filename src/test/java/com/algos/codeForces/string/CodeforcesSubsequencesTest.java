package com.algos.codeForces.string;

import org.junit.Assert;
import org.junit.Test;

public class CodeforcesSubsequencesTest {

    @Test
    public void test(){
        Assert.assertEquals("codeforces", CodeforcesSubsequences.find(1));
    }

    @Test
    public void test2(){
        Assert.assertEquals("codeforcesss", CodeforcesSubsequences.find(3));
    }
}
