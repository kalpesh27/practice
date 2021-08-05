package dfs;

import java.util.HashMap;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class AlienDictonaryAnotherTry {


    public static class Graph{
        public static HashMap<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        public Graph(String [] words){
            for(String s : words){
                for(char c : s.toCharArray()){
                    if(!map.containsKey(c))
                    map.put(c, new ArrayList<>());
                }
            }
        }

        public void addEdge(String [] words){

            for(int i=0; i<words.length-1; i++){

                String start = words[i];
                String end = words[i+1];

                int len = Math.min(start.length(),end.length());

                for(int j=0; j<len; j++) {

                    char out = start.charAt(j);
                    char in = end.charAt(j);
                    if(out!=in){
                        Graph.map.get(out).add(in);
                    }
                }
            }
        }
    }


    public static void main(String args[]){

        String [] words = {"wrt","wrf","er","ett","rftt"};

        System.out.println(" Another try on alien dictonary " );
        String s = alienOrder(words);
        System.out.println(s);

    }

    public static String alienOrder(String[] words) {


        String result = "";
        Graph g = new Graph(words);
        g.addEdge(words);
        System.out.println("The Map " + AlienDictonaryAnotherTry.Graph.map.toString());

        if(hasCycle()){
            System.out.println("Since it has cycle cannot proceed ");
            return "";
        }else{
            result = topoSort();
            System.out.println("Doest have cycle so proceed to topo sort ");
        }

        //Step 2 do the Topo Sort
        return result;
    }

    public static boolean hasCycle(){

        Set<Character> greySet = new HashSet();
        Set<Character> blackSet = new HashSet();

        for(Character c : Graph.map.keySet()){
            if(dfsCycle(c,greySet,blackSet)){
                return true;
            }
        }
        return false;
    }


    public static boolean dfsCycle(Character val, Set<Character> greySet, Set<Character> blackSet){

        //First step add to Grey Set
        greySet.add(val);

        //Second step loop through the childrens
        for(Character child : AlienDictonaryAnotherTry.Graph.map.get(val)){
            //Now check the conditions for cycle
            if(blackSet.contains(child)){
                continue;
            }
            if(greySet.contains(child)){
                return true;
            }
            if(dfsCycle(child,greySet,blackSet)){
                return true;
            }
        }
        //3. Step is to move from greySet to black Set since there is no cycle for this node and we visited all the childrens already
        greySet.remove(val);
        blackSet.add(val);
        return false;
    }

    public static String topoSort(){

        Set<Character> set = new HashSet<Character>();
        Stack<Character> stack = new Stack<Character>();

        for(Character c : AlienDictonaryAnotherTry.Graph.map.keySet()){

            if(!set.contains(c)){
                dfs_topo(c, set, stack);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
        return sb.toString();

    }

    public static void dfs_topo(Character val, Set<Character> set, Stack<Character> stack){

        set.add(val);
        for(Character i: AlienDictonaryAnotherTry.Graph.map.get(val)){
            if(!stack.contains(i)) {
                dfs_topo(i, set, stack);
            }
        }
        stack.push(val);
    }
}
