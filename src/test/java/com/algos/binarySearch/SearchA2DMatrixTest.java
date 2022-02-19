package com.algos.binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchA2DMatrixTest {

    SearchATwoDMatrix SearchA2DMatrixTest = new SearchATwoDMatrix();

    @Test
    public void basicPositiveTest(){
        Assert.assertEquals(SearchA2DMatrixTest.findTarget(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3),true);
    }

    @Test
    public void emptyArr(){
        Assert.assertEquals(SearchA2DMatrixTest.findTarget(new int[][]{}, 2),-1);
    }

    /*@Test
    public void basicRotatedArr(){
        Assert.assertEquals(SearchA2DMatrixTest.findTarget(new int[]{3,1,2}, 2),2);
    }

    @Test
    public void basicRotatedArr2(){
        Assert.assertEquals(SearchA2DMatrixTest.findTarget(new int[]{3, 5, 6, 5000, 1,2}, 5000),3);
    }

    @Test
    public void singleElement(){
        Assert.assertEquals(SearchA2DMatrixTest.findTarget(new int[]{2}, 2),0);
    }

    @Test
    public void testFromLeetCode(){
        Assert.assertEquals(SearchA2DMatrixTest.findTarget(new int[]{6,7,8,1,2,3,4,5}, 6),0);
    }*/

}
