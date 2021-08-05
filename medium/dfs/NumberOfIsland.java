package dfs;

import java.util.*;

public class NumberOfIsland {

    public static void main(String args[]){

        int [][] arr = new int [][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        int [][] arr1 = new int [][] {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };
        int i  = numIsland(arr);
        System.out.println(i);
    }

    static int [][] directions = new int [][] {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    public static int numIsland(int [][] arr){
    int [] result = new int [arr.length];
        int cnt= 0;
        for(int i =0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1 && i!=j){
                    result[i] = 1;
//                    dfs(arr,i,j);
//                    cnt= cnt+1;
                }
            }
        }

        System.out.println(Arrays.toString(result));
        return cnt;
    }

    public static void dfs(int [][] arr , int i, int j){

        //check 4 sides and do dfs on them.
        for(int [] dir : directions){
            int x = dir[0] + i;
            int y = dir[1] + j;

            if(x>=0 && y >=0 && x < arr.length && y <arr[0].length && arr[x][y] !=0){
                arr[x][y] = 0;
                dfs(arr,x,y);
            }
        }
    }
}
