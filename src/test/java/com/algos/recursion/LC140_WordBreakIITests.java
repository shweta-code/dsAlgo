package com.algos.recursion;

import com.algos.recurssion.LC140_WordBreakII_UsingQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC140_WordBreakIITests {

    LC140_WordBreakII_UsingQueue lc140WordBreakII = new LC140_WordBreakII_UsingQueue();

    @Test
    public void test1() {
        // String[] ans = new String[] {"cat","cats","and","sand","dog"};
        List<String> stringList = lc140WordBreakII.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        assertListsEquivalent(Arrays.asList("cat sand dog", "cats and dog"), stringList);
    }

    @Test
    public void test2() {
        // String[] ans = new String[] {"cat","cats","and","sand","dog"};
        List<String> stringList = lc140WordBreakII.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        assertListsEquivalent(Arrays.asList("pine apple pen apple","pine applepen apple","pineapple pen apple"), stringList);
    }

    public static <T> void assertListsEquivalent(List<T> expected, List<T> actual) {
        Set<T> expectedSet = new HashSet<>(expected);
        Set<T> actualSet = new HashSet<>(actual);
        Assert.assertEquals(expectedSet, actualSet);
    }
}
