package dfs;

import java.sql.Array;
import java.util.*;
public class AccountMerge {

    public static class Graph{

        String[] vertices;
        Map<String, List<String>> adjList;

        public Graph(String[] arr){
            this.vertices = arr;
            adjList = new HashMap();
            for(String s: arr) {
                adjList.put(s,new ArrayList<>());
            }
        }
        public void addEdge(String start, String end){
            this.adjList.get(start).add(end);
            //Dthis.adjList.get(end).add(start);
        }
    }

    public static void main(String args[]){
        List<List<String>> input = new ArrayList<>();
        List<String> internalList = new ArrayList<>();
        internalList.add("John");
        internalList.add("johnsmith@mail.com");
        internalList.add("john_newyork@mail.com");

        List<String> internalList1 = new ArrayList<>();
        internalList1.add("John");
        internalList1.add("johnsmith@mail.com");
        internalList1.add("john00@mail.com");

        List<String> internalList2 = new ArrayList<>();
        internalList2.add("Mary");
        internalList2.add("mary@mail.com");

        List<String> internalList3 = new ArrayList<>();
        internalList3.add("John");
        internalList3.add("johnnybravo@mail.com");

        input.add(internalList);
        input.add(internalList1);
        input.add(internalList2);
        input.add(internalList3);

        List<List<String>> out = accountsMerge(input);
        System.out.println(out);
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
       HashSet<String> filteredEmail = new HashSet<>();
        HashMap<String, String> map = new HashMap<>();


       for(int i =0; i<accounts.size(); i++){
            for(int j=0; j<accounts.get(i).size(); j++){
                if(j !=0){
                    //System.out.println(accounts.get(i).get(j));
                    filteredEmail.add(accounts.get(i).get(j));
                }
            }
       }

        String [] s = new String[filteredEmail.size()];
       filteredEmail.toArray(s);
       Graph g = new Graph(s);


        for(List<String> ss : accounts){
            map.put(ss.get(1), ss.get(0));
            int index = 1;
            if(ss.size() == 2){
                g.addEdge(ss.get(index), ss.get(index));
            }else if(ss.size() > index) {
                g.addEdge(ss.get(index), ss.get(index + 1));
            }
        }
  /*      System.out.println( "Map of name to email " + map);
        System.out.println(" Adjust List " + g.adjList);
*/
        List<List<String>> outerList = new ArrayList<>();

        for(Map.Entry<String, List<String>> e: g.adjList.entrySet()){
            //List<String> innerList = new ArrayList();
            if(e.getValue().size() > 0){
                String name = map.get(e.getKey());
                List<String> ss = e.getValue();
                if(!ss.contains(e.getKey())) {
                    ss.add(e.getKey());
                }
                //finalMap.put(name,ss);
//                System.out.println(name + " " + ss);
                ss.add(name);
                //innerList.add(ss);
                Collections.sort(ss);
                outerList.add(ss);
            }
        }

        System.out.println("Final List " + outerList);
        return outerList;
    }



}
