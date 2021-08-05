package tp;

import java.util.ArrayList;
import java.util.*;

public class checkArray {


    public static void main(String args[]){

        String s = "23";
        System.out.println(s.charAt(0));
        int i = s.charAt(0)-'0';
        System.out.println( " is it int version " + i);
        List<int[]> list = new ArrayList<>();
        list.add(new int []{0,1});

        System.out.println(list.contains(new int [] {0,1}));

    }

}
