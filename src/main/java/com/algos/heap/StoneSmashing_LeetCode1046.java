package com.algos.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class StoneSmashing_LeetCode1046 {

    public static void main(String[] args) {
        lastStoneWeight(new int[]{2,2});
    }

    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int stone: stones) {
            pq.add(stone);
        }
        System.out.println(Arrays.toString(pq.toArray()));
        while (pq.size() > 1) {
            Integer max1 = pq.poll();
//            System.out.println(max1.toString());
            Integer max2 = pq.poll();
//            System.out.println(max2.toString());
            assert max1 != null;
            assert max2 != null;
            if (!max1.equals(max2)) {
                pq.add(max1 > max2 ? max1 - max2 : max2 - max1);
            }
            System.out.println(Arrays.toString(pq.toArray()));
        }

        if(pq.size() == 0){
            return 0;
        }
        return pq.poll();


    }
}
