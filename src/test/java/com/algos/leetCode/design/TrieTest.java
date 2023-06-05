package com.algos.leetCode.design;

import com.algos.leetcode.design.Trie;
import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

    @Test
    public void testSearch1() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        Assert.assertFalse(trie.search("apk"));
    }

    @Test
    public void testSearch2() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        Assert.assertTrue(trie.search("app"));
    }

    @Test
    public void testSearch3() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
    }

    @Test
    public void testSearch4() {
        Trie trie = new Trie();
        trie.insert("hello");
        Assert.assertFalse(trie.search("helloa"));
    }

    @Test
    public void testStartsWith1() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        Assert.assertTrue(trie.startsWith("ap"));
    }

    @Test
    public void testStartsWith2() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        Assert.assertTrue(trie.startsWith("appl"));
    }

    @Test
    public void testStartsWith3() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        Assert.assertFalse(trie.startsWith("adk"));
    }

    @Test
    public void testStartsWith4() {
        Trie trie = new Trie();
        Assert.assertFalse(trie.startsWith("a"));
    }

    @Test
    public void testStartsWith5() {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        Assert.assertTrue(trie.startsWith("app"));
    }

    @Test
    public void testStartsWith6() {
        Trie trie = new Trie();
        trie.insert("a");
        Assert.assertTrue(trie.startsWith("a"));
    }

}
