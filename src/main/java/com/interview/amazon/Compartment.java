package com.interview.amazon;

import java.util.*;

// The solution to this question is not very elegant.
// We are first iterating over entire array to create a wall index
// Then we are doing binary search for each start and end index
// Overall the time complexity of this solution will be O(n) because we have iterated over the whole array as first step
// The space complexity of this solution will also be O(n)
public class Compartment {
    /*Given a string = |*|***| containing of | and *
    | - start/end of container
    * - inventory
    startingIndices - [ 1 , 3 , 5]
    endingIndices   - [ 2 , 4 , 6]
    These are all queries startingIndices , endingIndices
    You have to tell what is the inventory contained in startingIndex - endingIndex [1-2] - |* = 0
    You have to tell what is the inventory contained in startingIndex - endingIndex [3-4] - |* = 0
    You have to tell what is the inventory contained in startingIndex - endingIndex [5-6] - ** = 0
    */

    public static void main(String[] args) {
        inventoryContained("|*|***|" , new int[]{1,3,5}, new int[]{2,7,6});
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(7);
        int left = specialBinarySearchForLeftIndex(list , 0 , 2, 5);
        System.out.println(left);
        left = specialBinarySearchForLeftIndex(list , 0 , 2, 8);
        System.out.println(left);
        left = specialBinarySearchForLeftIndex(list , 0 , 2, -1);
        System.out.println(left);
        left = specialBinarySearchForLeftIndex(list , 0 , 2, 3);
        System.out.println(left);
        left = specialBinarySearchForLeftIndex(list , 0 , 2, 1);
        System.out.println(left);
        left = specialBinarySearchForLeftIndex(list , 0 , 2, 7);
        System.out.println(left);*/
    }

    private static void inventoryContained(String container, int[] startingIndices, int[] endingIndices) {
        char[] chars = container.toCharArray();
        List<Integer> walls = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '|'){
                walls.add(i+1);
            }
        }
        System.out.println(Arrays.toString(walls.toArray()));
        //sort queries with startingIndex
        List<Query> queries = new ArrayList<>();
        for (int i = 0; i < startingIndices.length; i++) {
            queries.add(new Query(startingIndices[i] , endingIndices[i]));
        }
        queries.sort(Comparator.comparingInt(o -> o.startingIndex));
        System.out.println(Arrays.toString(queries.toArray()));

        int left = 0;

        for (Query query : queries) {
            //Since queries are sorted, we can bit optimize to pass previous left.
            left = specialBinarySearchForLeftIndex(walls , left , walls.size() - 1 , query.startingIndex);
            System.out.println(left);
            int right = specialBinarySearchForRightIndex(walls , left , walls.size() - 1 , query.endingIndex);
            System.out.println(right);
            int answer = 0;
            for (int i = left+1; i <= right; i++) {
                Integer rightWall = walls.get(i);
                Integer leftWall = walls.get(i - 1);
                answer += (rightWall - leftWall);
            }
            System.out.println("left " + query.startingIndex + " right " +
                    query.endingIndex + " "+answer);

        }



    }

    private static int specialBinarySearchForRightIndex(List<Integer> wallIndex, int low, int high, int no) {
        while(high > low ){

            int mid = low + (high - low)/2;
            /*System.out.println(low +" "+ mid +" "+ high);*/
            Integer current = wallIndex.get(mid);
            if(current == no){
                return mid;
            } else if(current < no && mid + 1 < wallIndex.size() && wallIndex.get(mid + 1) > no){
                /*System.out.println("returning mid " + mid);*/
                return mid;
            } else if(current > no ){
                high = mid - 1;
            } else {
                low = mid + 1;
            }


        }
        return high;
    }

    private static int specialBinarySearchForLeftIndex(List<Integer> wallIndex, int low, int high, int no) {


        while(high > low ){

            int mid = low + (high - low)/2;

            Integer current = wallIndex.get(mid);
            if(current == no){
                return mid;
            } else if(current > no && mid - 1 >= 0 && wallIndex.get(mid - 1) < no){
                return mid;
            } else if(current > no ){
                high = mid - 1;
            } else {
                low = mid + 1;
            }


        }
        return high;

    }


    private static class Query {

        int startingIndex;
        int endingIndex;

        public Query(int startingIndex, int endingIndex) {
            this.startingIndex = startingIndex;
            this.endingIndex = endingIndex;
        }

        @Override
        public String toString() {
            return "Query{" +
                    "startingIndex=" + startingIndex +
                    ", endingIndex=" + endingIndex +
                    '}';
        }
    }
}

