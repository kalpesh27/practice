package dfs;

import java.util.*;
public class NoOfConnectedComponentsUnionTry {

    public static class DSU{

        int parent[];

        public DSU(int n){
            parent = new int [n];
            for(int i =0; i<parent.length; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            parent[find(x)] = find(y);
        }

    }

    public static void main(String args[]){

//        int [][] edges = new int [][]{
//                {0,1},
//                {1,2},
//                {3,4}
//        };

        int [][] edges = new int [][]{
                {0,1},
                {1,2},
                {2,3},
                {3,4}
        };

        int x = countComponents(5,edges);
        System.out.println(x);

    }

    public static int countComponents(int n, int[][] edges) {

        //Step 1  // create the DSU base class which find and union method
        DSU dsu = new DSU(n);

        //Step 2 // build the graph

        for(int [] edge : edges){
            //here each edge
            int x = edge[0];
            int y = edge[1];
            dsu.union(x,y);
        }

        Set<Integer> set = new HashSet<>();

        for(int i : dsu.parent){
            set.add(dsu.find(i));
        }

        System.out.println(set.toString());

        return set.size();
    }
}
