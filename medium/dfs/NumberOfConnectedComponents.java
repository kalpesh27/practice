package dfs;
import java.util.*;

public class NumberOfConnectedComponents {
    public static class Graph{

        int val;
        int [][] adjList;

        public Graph(int n){
            adjList = new int [n][n];
        }
        public void addEdge(int [][] edges){
            for(int [] i: edges){
                int x= i[0];
                int y= i[1];
                adjList[x][y] = 1;
            }
        }
    }
    public static void main(String args[]){
        int [][] edges = new int [][]{
                {0,1},
                {1,2},
                {3,4}
        };

        System.out.println("After");
        Graph g = new Graph(5);
        g.addEdge(edges);

        for(int [] i: g.adjList){
            System.out.println(Arrays.toString(i));
        }

    }
}
