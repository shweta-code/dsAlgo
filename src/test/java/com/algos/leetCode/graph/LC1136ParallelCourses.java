package com.algos.leetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1136ParallelCourses {


    public int minimumSemesters(int n, int[][] relations) {

        List<Integer>[] adjList = new List[n];
        for(int i = 0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }

        int[] indegrees = new int[n];
        for(int[] relation: relations){
            adjList[relation[0]-1].add(relation[1]-1);
            indegrees[relation[1]-1]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }


        int noOfSemesters = 0;
        int cnt =0;
        while(!q.isEmpty()){

            int size = q.size();
            noOfSemesters++;

            for(int i = 0; i < size; i++){

                Integer node = q.poll();
                cnt++;
                indegrees[node]--;
                // adjList[node];
                for(Integer adjNode: adjList[node]){
                    indegrees[adjNode]--;
                    if(indegrees[adjNode] == 0){
                        q.add(adjNode);
                    }
                }
            }

        }

        if(cnt != n){
            return -1;
        } else {
            return noOfSemesters;
        }

        // return -1;
    }

}
