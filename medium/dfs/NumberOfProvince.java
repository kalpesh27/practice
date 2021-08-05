package dfs;

import java.util.*;

public class NumberOfProvince {

    public static void main(String args[]){
        System.out.println(" Program on number of province ");
        int [][] arr = new int [][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int i = findCircleNum(arr);
        System.out.println(i);
    }

    public static int findCircleNum(int[][] M) {
        int numOfProvince =0;
        HashSet<Integer> visited = new HashSet();
        for(int i =0; i<M.length; i++){
            if(!visited.contains(i)){
                dfs(M,visited,i);
                numOfProvince = numOfProvince +1;
            }
        }

        return numOfProvince;
    }

    public static void dfs(int [][] M, HashSet<Integer> visited, int start){
        visited.add(start);
        for(int i =0; i<M.length; i++){
            if(M[start][i] == 1 && !visited.contains(i)){
                dfs(M,visited,i);
            }
        }

    }
}
