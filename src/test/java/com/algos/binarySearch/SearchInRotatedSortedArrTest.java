package com.algos.binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrTest {

    SearchInRotatedSortedArr searchInRotatedSortedArr = new SearchInRotatedSortedArr();

    @Test
    public void basicPositiveTest(){
        Assert.assertEquals(searchInRotatedSortedArr.findTarget(new int[]{1,2, 3}, 2),1);
    }

    @Test
    public void emptyArr(){
        Assert.assertEquals(searchInRotatedSortedArr.findTarget(new int[]{}, 2),-1);
    }

    @Test
    public void basicRotatedArr(){
        Assert.assertEquals(searchInRotatedSortedArr.findTarget(new int[]{3,1,2}, 2),2);
    }

    @Test
    public void basicRotatedArr2(){
        Assert.assertEquals(searchInRotatedSortedArr.findTarget(new int[]{3, 5, 6, 5000, 1,2}, 5000),3);
    }

    @Test
    public void singleElement(){
        Assert.assertEquals(searchInRotatedSortedArr.findTarget(new int[]{2}, 2),0);
    }

    @Test
    public void testFromLeetCode(){
        Assert.assertEquals(searchInRotatedSortedArr.findTarget(new int[]{6,7,8,1,2,3,4,5}, 6),0);
    }

}
