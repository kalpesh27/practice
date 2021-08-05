package dfs;
import java.util.*;

public class CourseScheduleWithColoringTechnique {

    public static class Graph{
        int val;
        static HashMap<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();

        public Graph(int x){
            this.val = x;

            for(int i=0; i<x; i++){
                map.put(i, new ArrayList<>());
            }
        }
        public void addEdge(int [][] edges){
            for(int [] i : edges){
                int x = i[0];
                int y = i[1];
                map.get(x).add(y);
            }
        }
    }

    public static void main(String args[]){


        System.out.println(" Program to detect cycle in a graph using a coloring technique" +
                " Grey Area means the node is being visited" +
                "Black area means the node has no children and its done navigating" +
                "white area means the node is yet to be visited ");

//        int [][] prereq = new int [][] {
//                {1,0},
//                {0,1}
//        };

        int [][] prereq = new int [][] {
                {0,1}
        };



        System.out.println(canFinish(2,prereq));

    }

    public static boolean canFinish(int numOfCourses, int [][] prerequisites){

        //Set<Integer> whiteSet = new HashSet<Integer>();
        Set<Integer> greySet = new HashSet<Integer>();
        Set<Integer> blackSet = new HashSet<Integer>();

        Graph g = new Graph(2);
        g.addEdge(prerequisites);

        for(int i=0; i<numOfCourses; i++){
            if(dfs(i,greySet,blackSet)){
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int val, Set<Integer> greySet, Set<Integer> blackSet){

        //Add the current value to greySet
        greySet.add(val);

        for(int i : Graph.map.get(val)){
            //Here we are iterating over the childerns

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
