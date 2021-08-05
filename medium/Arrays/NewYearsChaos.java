package Arrays;

import java.util.ArrayList;
import java.util.List;

public class NewYearsChaos {


    public static void main(String args[]){
        int [] q = {1,2,5,3,7,8,6,4};
        minimumBribes(q);
    }

    static void minimumBribes(int[] q) {
        int len  = q.length;
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=len; i++){
            list.add(i);
        }

        int max = 0;
        if(q!=null && q.length > 0){
            for(int i =0; i<q.length; i++){
                int x = q[i];
                int y = list.get(i);
                if(x != y){
                    if (x > y){
                        max = max + (x-y);
                    }
                }
            }
        }
        if(max < 4){
            System.out.println(max);
        }else{
            System.out.println("Too chaotic");
        }
    }
}
