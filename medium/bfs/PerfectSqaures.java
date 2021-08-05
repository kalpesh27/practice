package bfs;

import java.util.ArrayList;
import java.util.*;

public class PerfectSqaures {

    public static void main(String args[]){

        System.out.println("Program on Perfect squares ");

        int i = numSquares(13);
        System.out.println(i);
    }

    public static int numSquares(int n) {
        List<Integer> list = new ArrayList<Integer>();
        boolean [] visited = new boolean[n];

        //Step 1 try to calculate the perfect squares and put on the list
        //So first make an array of perfect squares and till what number you can divide by 2 with given number

        int k = n/2;

        for(int i=1; i<k; i++){
            if(i *i < n) {
                list.add(i * i);
            }
        }
        System.out.println(" the Perfect square list " + list);
        // now time to deduce with the targeted number

        Queue<Integer> q = new LinkedList();
        q.offer(n);
        int level=0;

        while(!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                int s = q.poll();

                for(int j : list){
                    int remain = s - j;

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

        return n;
    }


}
