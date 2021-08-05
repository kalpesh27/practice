package dfs;

import java.util.*;

public class checkingSorting {

    public static void main(String args[]){

        List<String> list = new ArrayList<>();
        list.add("johnsmith@mail.com");
        list.add("john_newyork@mail.com");
        list.add("john00@mail.com");
        Collections.sort(list);

        System.out.println(" Sorting order " + list);
    }
}
