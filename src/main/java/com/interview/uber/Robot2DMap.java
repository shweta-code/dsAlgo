package com.interview.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/discuss/interview-question/3326856/Valid-Robot-Position-Question
// https://leetcode.com/discuss/interview-question/4718477/Uber-or-Phone-Screen-or-Amsterdam
public class Robot2DMap {

    public static void main(String[] args) {

        char[][] matrix = new char[][]{
                {'o','e','e','e','x'},
                {'e','o','x','x','x'},
                {'e','e','e','e','e'},
                {'x','e','o','e','e'},
                {'x','e','o','e','x'}
        };
        int[] query = {2,2,4,1};
        List<List<Integer>> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int[][][] dist =new int[n][m][4];

        int TOP = 0;
        int LEFT = 1;
        int DOWN = 2;
        int RIGHT = 3;

        for (int i = 0; i < m; i++){
            int top = -1;
            for (int j = 0; j < n; j++) {
                if(matrix[j][i] == 'x'){
                    top = j;
                } else if(matrix[j][i] == 'o') {
                    dist[j][i][TOP] = (j - top);
                }
            }
        }

        for (int i = 0; i < n; i++){
            int left = -1;
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 'x'){
                    left = j;
                } else if(matrix[i][j] == 'o') {
                    dist[i][j][LEFT] = (j - left);
                }
            }
        }

        int[] top = new int[m];
        Arrays.fill(top, -1);
        for (int i = 0; i < n; i++) {
            int left = -1;
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 'x'){
                    left = j;
                    top[j] = i;
                } else if(matrix[i][j] == 'o') {
                    dist[i][j][LEFT] = (j - left);
                    dist[i][j][TOP] = (i - top[j]);
                }
            }
        }



        for (int i = m-1; i >= 0; i--){
            int bottom = n;
            for (int j = n-1; j >= 0; j--) {
                if(matrix[j][i] == 'x'){
                    bottom = j;
                } else if(matrix[j][i] == 'o') {
                    dist[j][i][DOWN] = (bottom - j);
                }
            }
        }

        for (int i = n-1; i >= 0; i--){
            int right = m;
            for (int j = m-1; j >= 0; j--) {
                if(matrix[i][j] == 'x'){
                    right = j;
                } else if(matrix[i][j] == 'o') {
                    dist[i][j][RIGHT] = (right - j);
                }
            }
        }



        int[] down = new int[m];
        Arrays.fill(down, n);
        for (int i = n-1; i >= 0; i--) {
            int right = m;
            for (int j = m-1; j >= 0; j--) {
                if(matrix[i][j] == 'x'){
                    right = j;
                    down[j] = i;
                } else if(matrix[i][j] == 'o') {
                    dist[i][j][RIGHT] = (right - j);
                    dist[i][j][DOWN] = (down[j] - i);
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(Arrays.toString(dist[i][j]));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(Arrays.equals(dist[i][j], query)){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        System.out.println(Arrays.toString(ans.toArray()));





    }
}
