package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class CourseSchedule2WithTopologicalSortAndCyclicCheck {

    public static class Graph{
        int val;
        static HashMap<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        public Graph(int x){
            this.val = x;
            for(int i=0; i<x; i++){
                map.put(i,new ArrayList<Integer>());
            }
        }

        public void addEdge(int [][] prereq){
            for(int [] i: prereq){
                int x = i[0];
                int y = i[1];
                map.get(x).add(y);
            }
        }

    }

    public static void main(String args[]){
//        int [][] prereq = {
//                {1,0},
//                {2,0},
//                {3,1},
//                {3,2}
//        };
//        int numOfCourses = 4;

        int [][] prereq = {

        };
        int numOfCourses = 1;

        int [] result = findOrder(numOfCourses,prereq);
        System.out.println(Arrays.toString(result));

    }

    public static int [] findOrder(int numOfCourses, int [][] prereq){
        int [] result = new int [numOfCourses];

        Graph g = new Graph(numOfCourses);
        g.addEdge(prereq);

        if(hasCycle(numOfCourses)){
            System.out.println("The graph has cycle so cannot continue ");
            return result;
        }else{
            System.out.println("Graph has no cycle so can continue ");
            result = topoSort(numOfCourses);
        }

        return result;
    }

    public static int [] topoSort(int numOfCourses){

        Set<Integer> set = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<numOfCourses; i++){

            if(!set.contains(i)){
                dfs_topo(i, set, stack);
            }
        }
        System.out.println("Printing topo order " + stack.toString());
        int [] result = stack.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    public static void dfs_topo(int val, Set<Integer> set, Stack<Integer> stack){

        set.add(val);
        for(Integer i: Graph.map.get(val)){
            if(!stack.contains(i)) {
                dfs_topo(i, set, stack);
            }
        }
        stack.push(val);

    }

    public static boolean hasCycle(int numOfCourses){

        Set<Integer> greySet = new HashSet<Integer>();
        Set<Integer> blackSet = new HashSet<Integer>();

        for(int i=0; i<numOfCourses; i++) {
            if(dfs_hasCycle(i, greySet, blackSet)){
                return true;
            }
        }

        return false;
    }

    public static boolean dfs_hasCycle(int val, Set<Integer> greySet, Set<Integer> blackSet){


        //3 Steps

        //1. step 1 move the value to grey sEt
        greySet.add(val);

        //2. Step 2 check if the value in greySet has children and loop through each children as dsf_cycle

        for(Integer i: Graph.map.get(val)){

            if(blackSet.contains(i)){
                continue;
            }
            if(greySet.contains(i)){
                return true;
            }
            if(dfs_hasCycle(i,greySet,blackSet)){
                return true;
            }

        }

        //3. Move the value from greySet to black Set after done.
        greySet.remove(val);
        blackSet.add(val);
        return false;
    }


}
