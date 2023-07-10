package com.algos.leetCode.slidingWindow;

import com.algos.leetcode.slidingWindow.LC904FruitIntoBaskets;
import org.junit.Assert;
import org.junit.Test;

public class LC904FruitIntoBasketsTest {

    private final LC904FruitIntoBaskets lc904FruitIntoBaskets = new LC904FruitIntoBaskets();

    @Test
    public void testForZeroFruits() {
        int totalFruits = lc904FruitIntoBaskets.totalFruit(new int[]{});
        Assert.assertEquals(0, totalFruits);
    }

    @Test
    public void testForSingleType() {
        int totalFruits = lc904FruitIntoBaskets.totalFruit(new int[]{1, 1, 1});
        Assert.assertEquals(3, totalFruits);
    }

    @Test
    public void testForTwoType() {
        int totalFruits = lc904FruitIntoBaskets.totalFruit(new int[]{1, 2, 1, 2, 1});
        Assert.assertEquals(5, totalFruits);
    }

    @Test
    public void testForOnePieceOfMultipleTypes() {
        int totalFruits = lc904FruitIntoBaskets.totalFruit(new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals(2, totalFruits);
    }



    @Test
    public void testForThreeTypes() {
        int totalFruits = lc904FruitIntoBaskets.totalFruit(new int[]{1, 2, 3, 3, 3, 3});
        Assert.assertEquals(5, totalFruits);
    }

    @Test
    public void testForInitialWindowAsAns() {
        int totalFruits = lc904FruitIntoBaskets.totalFruit(new int[]{1, 1, 2, 1, 2, 3, 3, 3, 4, 5});
        Assert.assertEquals(5, totalFruits);
    }

    @Test
    public void testForMidWindowAsAns() {
        int totalFruits = lc904FruitIntoBaskets.totalFruit(new int[]{1, 1, 2, 1, 2, 2, 2, 3, 3, 3, 4, 5});
        Assert.assertEquals(6, totalFruits);
    }

    @Test
    public void testForEndWindowAsAns() {
        int totalFruits = lc904FruitIntoBaskets.totalFruit(new int[]{1, 1, 2, 1, 2, 3, 3, 3, 4, 4, 4, 4, 4});
        Assert.assertEquals(8, totalFruits);
    }



}
