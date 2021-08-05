package bfs;
import java.util.*;


public class RottenOranges {


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

        int time = orangesRotting(arr2);
        System.out.println(time);

    }

    public  static int orangesRotting(int[][] grid) {

        int timeElapsed=-1;
        int totalFreshOranges = 0;

        int [][] directions = new int [][]{
                {1,0},
                {-1,0},
                {0,-1},
                {0,1}
        };

        int ROW  = grid.length;
        int COL = grid[0].length;

        Queue<int[]> q = new LinkedList();

        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if(grid[i][j] == 2){
                    q.offer(new int [] {i,j});
                }else if(grid[i][j] == 1){
                    totalFreshOranges++;
                }
            }
        }

        if(totalFreshOranges == 0){
            return 0;
        }

        while(!q.isEmpty()){
            int size = q.size();
            timeElapsed++;

            for(int i=0; i<size; i++){
                int [] pos = q.poll();
                //we are here means that the orange is rotten and the neighbors will also get rotten
                for(int [] dir : directions){
                    int j = pos[0] + dir[0];
                    int k = pos[1] + dir[1];
                    //edge case
                    if(j >=0 && k >=0  && j <ROW && k < COL && grid[j][k] !=0 && grid[j][k] == 1){
                        grid[j][k] = 2;
                        totalFreshOranges--;
                        q.offer(new int[]{j,k});
                    }
                }
            }
        }

        if(totalFreshOranges == 0){
            return timeElapsed;
        }else{
            return -1;
        }
    }
}
