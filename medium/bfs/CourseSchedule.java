package bfs;

import java.util.*;

public class CourseSchedule {

    public static class Node{
        int val;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        public Node(int total){
            this.val = total;
            for(int i=0; i<this.val; i++){
                map.put(i, new ArrayList<Integer>());
            }
        }

        public void addEdge(int [][] prerequisites){
            for(int [] pre : prerequisites){
                int x = pre[0];
                int y = pre[1];
                map.get(x).add(y);
            }
        }
    }

    public static void main(String args[]){

        int [][] prerequisites = new int [][]{
                                        {0,1},
                                        {1,0}};
        int numOfCourses = 2;

        boolean b = canFinish(numOfCourses, prerequisites);
        System.out.println(b);
        System.out.println("Program on Course Schedule");

    }

    public static boolean canFinish(int numOfCourses, int[][] prerequisites){


        //Now that we have sorted out the Graph node and add the basic values

        Node n = new Node(numOfCourses);
        n.addEdge(prerequisites);

        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[numOfCourses];

        for(int i=0; i<numOfCourses; i++){
//            if(!visited[i] && !stack.contains(i)){
//                stack.push(i);
//                //Now check the neighbors
//                    ArrayList<Integer> list = n.map.get(i);
//                    for(Integer k : list){
//                        if(stack.contains(k)){
//                            return false;
//                        }else if(!visited[k]){
//                            visited[k] = true;
//                            stack.push(k);
//                        }
//                    }
//
//            }
            stack.push(i);

            while(!stack.isEmpty()){
                /// Get the First element from STack and check for its neighbors and push them to stack
                int k = stack.peek();
                if(n.map.get(k).size() > 0) {
                    for (Integer j : n.map.get(k)) {
                        if(stack.contains(j)){
                            return false;
                        }else{
                            stack.push(j);
                        }
                    }
                }

            }
        }

        return true;
    }
}
