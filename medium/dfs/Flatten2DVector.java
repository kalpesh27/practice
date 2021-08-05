package dfs;
import java.util.*;

public class Flatten2DVector {

    static List<Integer> list = new ArrayList();
    public static void main(String args[]){
        int [][] arr = new int [][] {
                {1,2},
                {3},
                {4}
        };
        for(int [] i : arr){
                flatten(i);
        }

        System.out.println("list " + list);
    }

    public static void flatten(int [] arr){
        for(int i: arr){
            list.add(i);
        }
    }



}
