package com.algos.recursion;

import com.algos.recurssion.StringWithAdditiveSequence;
import org.junit.Assert;
import org.junit.Test;

public class StringWithAdditiveSequenceTest {

    private final StringWithAdditiveSequence stringWithAdditiveSequence = new StringWithAdditiveSequence();

    @Test
    public void stringWithAdditiveSequenceTest1() {
        String input = "1991001991";
        final boolean additive = StringWithAdditiveSequence.isAdditive(input);
        //1991 00 1991
        Assert.assertEquals(true, additive);


    }

    @Test
    public void stringWithAdditiveSequenceTest2() {
        String input = "199100199";
        final boolean additive = StringWithAdditiveSequence.isAdditive(input);
        Assert.assertEquals(true, additive);


    }

    @Test
    public void stringWithAdditiveSequenceTest3() {
        String input = "235813";
        final boolean additive = StringWithAdditiveSequence.isAdditive(input);
        Assert.assertEquals(true, additive);


    }

    @Test
    public void stringWithAdditiveSequenceTest4() {
        String input = "2358131";
        final boolean additive = StringWithAdditiveSequence.isAdditive(input);
        Assert.assertEquals(false, additive);


    }

    @Test
    public void stringWithAdditiveSequenceTest5() {
        String input = "12345678";
        final boolean additive = StringWithAdditiveSequence.isAdditive(input);
        Assert.assertEquals(false, additive);
    }


}
