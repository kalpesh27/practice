package bfs;
import java.util.*;

public class NumberOfIsland {

    public static void main(String args[]){
        System.out.println(" Program on Number of Island using bfs ");
        char [] [] arr = new char [][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        int i = numIslands(arr);
        System.out.println(i);
    }

    public static int numIslands(char [][] grid){
        int total= 0;

        for(int i =0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j] == '1') {
                    helper(grid, i, j);
                    total++;
                }
            }
        }
        return total;
    }

    public static void helper(char[][] grid, int start, int end) {

        //4 Directions
        int [][] directions = new int [][]{
                {0,1},
                {0,-1},
                {-1,0},
                {1,0}
        };
        //now initialize a Queue and push the starting node on the queue
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int []{start,end});

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int h =0; h<size; h++) {
                int[] pos = queue.poll();
                for (int[] i : directions) {
                    int j = pos[0] + i[0];
                    int k = pos[1] + i[1];

                    if (j >= 0 && k >= 0 && j <= grid.length-1 && k <= grid[0].length-1) {
                        if (grid[j][k] == '1') {
                            queue.add(new int []{j,k});
                        }
                    }

                }
                grid[pos[0]][pos[1]] = '0';
            }
        }
    }



}
