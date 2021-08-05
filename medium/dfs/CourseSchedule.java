package dfs;

import java.util.*;

public class CourseSchedule {

    public static class Graph{
        static Map<Integer, List<Integer>> map = new HashMap();

        public Graph(int numCourses){
            for(int i =0; i<numCourses; i++){
                map.put(i, new ArrayList<>());
            }
        }
        public void addEdge(int [][] pre){
            for(int [] i : pre){
                int x = i[0];
                int y=  i[1];
                map.get(x).add(y);
            }
        }
    }


    public static void main(String args[]){
        System.out.println(" Program on course schedule");

        int [][] pre = {
                {1,0},
                {0,1}
        };
        boolean b = canFinish(2,pre);
        System.out.println(b);
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph g = new Graph(numCourses);
        g.addEdge(prerequisites);

        //GreySet
        //BlackSet
        Set<Integer> greySet = new HashSet();
        Set<Integer> blackSet = new HashSet<>();

        for(int i =0; i<numCourses; i++){
            if(dfs(i,greySet,blackSet)){
                return false;
            }
        }

        return true;
    }

    public static boolean dfs(int val, Set<Integer> greySet, Set<Integer> blackSet){

        greySet.add(val);

        for(int i : Graph.map.get(val)){

            if(blackSet.contains(i)){
                continue;
            }
            if(greySet.contains(i)){
                return true;
            }
            if(dfs(i,greySet,blackSet)){
                return true;
            }
        }
        greySet.remove(val);
        blackSet.add(val);
        return false;
    }
}
