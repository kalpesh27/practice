package bfs;


import java.util.*;


public class WallsAndGates {

    public static void main(String args[]){
        System.out.println(" Program on Walls and Gates using BFS ");

        int [][] input = new int [][] {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };

        wallsAndGates(input);
        for(int []i : input){
            System.out.println(Arrays.toString(i));
        }

    }

    public  static void wallsAndGates(int[][] rooms) {
        int empty = 2147483647;
        int [][] fourSides = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0},
        };

        int distance = 0;
        Queue<int []> queue = new LinkedList();
        int [][] visited = new int [rooms.length][rooms[0].length];

        for(int i =0; i<rooms.length; i++){
            for(int j =0; j<rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            distance = distance +1;
            int size = queue.size();
            for(int i =0; i<size; i++){
                int [] pos = queue.poll();
                for(int [] each: fourSides){
                    int j = pos[0] + each[0];
                    int k = pos[1] + each[1];
                    if(j >= 0 && k >= 0 && j <= rooms.length-1 && k <= rooms[0].length-1 && visited[j][k]!=1){
                        if(rooms[j][k] == empty){
                            rooms[j][k] = distance;
                            queue.add(new int[]{j, k});
                        }
                    }
                }
                visited[pos[0]][pos[1]] = 1;
            }
        }

    }




}
