package com.algos.interview.amazon.revision;

import com.interview.amazon.revision.EfficiencyOfCloudFront;
import org.junit.Assert;
import org.junit.Test;

public class EfficiencyOfCloudFrontTest {

    EfficiencyOfCloudFront efficiencyOfCloudFront = new EfficiencyOfCloudFront();
    @Test
    public void test1() {
        int eff = efficiencyOfCloudFront.calculateEfficiency(10, new int[][]{{9, 8}, {0, 1}, {7, 4}, {1, 3}, {6, 4}, {3, 5}});
        Assert.assertEquals(6, eff);
    }

}
