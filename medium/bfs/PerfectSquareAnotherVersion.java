package bfs;
import java.util.*;


public class PerfectSquareAnotherVersion {

    public static void main(String args[]){

        System.out.println("Program on Perfect squares ");

        int i = numSquares(12);
        System.out.println(i);
    }

    public static int numSquares(int n) {

        // So we will implement using BFS ..


        boolean [] visited = new boolean[n];
        int level=0;
        //Create the Perfect Square List
        int sqRoot = (int) Math.sqrt(n);
        int [] perSquareArray = new int [sqRoot];

        for(int i =1; i<=sqRoot; i++){
            perSquareArray[i-1] = i*i;
        }

        Queue<Integer> q = new LinkedList();
        q.offer(n);

        while(!q.isEmpty()){
            int size = q.size();
            level++;

            for(int j=0; j<size; j++){

                int num = q.poll();

                for(int k : perSquareArray){

                    int remain = num - k;

                    if(remain == 0){
                        return level;
                    }else if(remain > 0 && !visited[remain-1]){
                        q.offer(remain);
                        visited[remain-1] = true;
                    }else if(remain <0){
                        break;
                    }
                }
            }


        }
        return 0;
    }
}
