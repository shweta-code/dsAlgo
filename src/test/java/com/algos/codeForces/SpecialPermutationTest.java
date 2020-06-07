package com.algos.codeForces;

import org.junit.Assert;
import org.junit.Test;

public class SpecialPermutationTest {

    @Test
    public void _6(){
        validate(SpecialPermutation.printWithDiffBWTwoAndFour(6));
        ///Assert diff between ints is greater than 2 and less than 4
    }

    @Test
    public void _4(){
        validate(SpecialPermutation.printWithDiffBWTwoAndFour(4));
        ///Assert diff between ints is greater than 2 and less than 4
    }

    @Test
    public void _7(){
        validate(SpecialPermutation.printWithDiffBWTwoAndFour(7));
        ///Assert diff between ints is greater than 2 and less than 4
    }

    @Test
    public void _12(){
        validate(SpecialPermutation.printWithDiffBWTwoAndFour(12));
        ///Assert diff between ints is greater than 2 and less than 4
    }

    @Test
    public void _13(){
        validate(SpecialPermutation.printWithDiffBWTwoAndFour(13));
        ///Assert diff between ints is greater than 2 and less than 4
    }

    @Test
    public void _1000(){
        int[] arr = SpecialPermutation.printWithDiffBWTwoAndFour(1000);
        validate(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        //System.out.println(SpecialPermutation.printWithDiffBWTwoAndFour(1000));
        ///Assert diff between ints is greater than 2 and less than 4
    }

    @Test
    public void _2(){
        Assert.assertEquals(SpecialPermutation.printWithDiffBWTwoAndFour(2).length, 1);
        Assert.assertEquals(SpecialPermutation.printWithDiffBWTwoAndFour(2)[0], -1);
        ///Assert diff between ints is greater than 2 and less than 4
    }

    @Test
    public void _3(){
        Assert.assertEquals(SpecialPermutation.printWithDiffBWTwoAndFour(2).length, 1);
        Assert.assertEquals(SpecialPermutation.printWithDiffBWTwoAndFour(2)[0], -1);
        ///Assert diff between ints is greater than 2 and less than 4
    }

    private void validate(int[] arr){
        Assert.assertTrue( Math.abs(arr[1] - arr[0])<= 4);
        Assert.assertTrue( Math.abs(arr[1] - arr[0]) >= 2);
        for (int i = 1; i <= arr.length - 2 ; i++) {
            Assert.assertTrue( Math.abs(arr[i] - arr[i+1])<= 4);
            Assert.assertTrue( Math.abs(arr[i] - arr[i+1])>= 2);
            Assert.assertTrue( Math.abs(arr[i+1] - arr[i])<= 4);
            Assert.assertTrue( Math.abs(arr[i+1] - arr[i]) >= 2);
        }
        Assert.assertTrue( Math.abs(arr[arr.length-2] - arr[arr.length-1])<= 4);
        Assert.assertTrue( Math.abs(arr[arr.length-2] - arr[arr.length-1])>=2);

    }

}
