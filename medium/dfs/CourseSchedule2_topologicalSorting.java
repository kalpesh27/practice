package dfs;
import java.util.*;


public class CourseSchedule2_topologicalSorting {

    public static class Graph{

        int val;
        public static HashMap<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();

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
//
//        int [][] prereq = {
//                {1,0},
//                {2,0},
//                {3,1},
//                {3,2}
//        };

//        int [][] prereq = {
//                {1,0},
//        };

        int [][] prereq = {
                {1,0},
                {2,0},
        };


        int [] res = findOrder(1, prereq);
        System.out.println(Arrays.toString(res));


    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int [] result = new int[numCourses];
        Integer [] res = new Integer[numCourses];
        Graph g = new Graph(numCourses);
        g.addEdge(prerequisites);

        Set<Integer> set = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<>();

        for(int i= 0; i<numCourses; i++){
            if(!set.contains(i)){
                dfs(i,set,stack);
            }
        }
        System.out.println("");


        return result = stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void dfs(int val, Set<Integer> set, Stack<Integer> stack){

            set.add(val);

            for(Integer i : Graph.map.get(val)){
                if(set.contains(i)){
                   continue;
                }
                dfs(i,set,stack);
            }
            stack.push(val);
    }
}
