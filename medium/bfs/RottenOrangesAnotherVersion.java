package bfs;

import java.util.*;

public class RottenOrangesAnotherVersion {
    public static void main(String args[]){

        int [][] arr =  {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };



        int [][] arr1 =  {
                {2,1,1},
                {0,1,1},
                {1,0,1}

        };

        int [][] arr2 = {
                {0,2}
        };

        int [][] arr3 ={
                {2},
                {1}
        };

        int [][] arr4 = {
                {0}
        };



        int time = orangesRotting(arr4);
        System.out.println(time);

    }


    public static int orangesRotting(int[][] grid) {
        int [][] directions  = new int [][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        if(grid ==null || grid.length==0 || grid[0].length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        Queue<int []> q = new LinkedList();
        int totalOranges = 0;
        for(int i =0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]!=0 && grid[i][j]!=2)
                    totalOranges += 1;
            }
        }
        if(totalOranges == 0){
            return 0;
        }
        System.out.println("total "+ totalOranges);
        for(int i =0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int [] {i,j});
                }
            }
        }
        int minutes =0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0; i<size; i++){
                int [] point = q.poll();


                //Check if the total Oranges = 7
                //Check neighbors//
                for(int [] direct : directions){
                    int row = direct[0] + point[0];
                    int col = direct[1] + point[1];

                    //check for edge cases
                    if(row < 0 || col< 0 || row >=m || col >=n || grid[row][col] == 0 || grid[row][col] == 2){
                        continue;
                    }
                    grid[row][col] = 2;
                    q.offer(new int [] {row,col});
                    totalOranges--;
                }
            }
            minutes++;
        }
        if(totalOranges == 0){
            return minutes-1;
        }

        return -1;
    }
}
