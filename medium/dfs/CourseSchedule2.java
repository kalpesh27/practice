package dfs;

import java.util.*;

public class CourseSchedule2 {


    public static class Graph{

        static HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        public Graph(int x){

            for(int i=0; i<x; i++){
                map.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int [][] prereq){
            for(int [] pre : prereq){
                    int x = pre[0];
                    int y = pre[1];
                    map.get(x).add(y);
            }
        }
    }



    public static void main(String args[]){

        int [][] prereq = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        Graph g = new Graph(4);
        g.addEdge(prereq);

        int [] k  = findOrder(4, prereq);
        System.out.println(Arrays.toString(k));
    }

    public  static int[] findOrder(int numCourses, int[][] prerequisites) {

        int [] result = new int [numCourses];
        if(hasCycle(numCourses)){
            System.out.println("Has cycle cannot proceed");
            return result;
        }else{
            result = topoSort(numCourses);
        }
        return result;
    }

    public static int[] topoSort(int num){

        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<num;i++){
            if(!set.contains(i)) {
                dfsTopoSort(i, set, stack);
            }
        }
        int [] j = stack.stream().mapToInt(Integer::intValue).toArray();
        return j;
    }

    public static void dfsTopoSort(int val, Set<Integer> set, Stack<Integer> stack){
        set.add(val);
        for(int i : Graph.map.get(val)){
            if(!stack.contains(i)){
                dfsTopoSort(i,set,stack);
            }
        }
        stack.push(val);
    }
    public static boolean hasCycle(int numOfCourses){

        Set<Integer> greySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();

        for(int i =0; i<numOfCourses; i++){
            if(dfsCycle(i,greySet,blackSet)){
                return true;
            }
        }
        return false;
    }

    public static boolean dfsCycle(int val, Set<Integer> greySet, Set<Integer> blackSet){

        greySet.add(val);

        for(int i : Graph.map.get(val)){

            if(blackSet.contains(i)){
                continue;
            }
            if(greySet.contains(i)){
                return true;
            }

            if(dfsCycle(i, greySet,blackSet)){
                return true;
            }
        }
        greySet.remove(val);
        blackSet.add(val);
        return false;
    }
}
