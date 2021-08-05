package dfs;
import java.util.*;


class AlienDictonary{

    public static class Graph{
        int val;
        public static HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();

        public Graph(Set<Character> x){
            this.val = x.size();
            for(Character c : x){
                map.put(c, new HashSet<>());
            }
        }

        public void addEdge(String [] words){
            //if each word in the array is more than length 1 then don't stitch else stitch

            StringBuilder sb = new StringBuilder();
            for(String s: words ){
                if(s.length() > 1) {
                    sb.append(s);
                }else{
                        for(int i=0; i<s.length()-1; i++){
                            if(s.charAt(i)!= s.charAt(i+1))
                                map.get(s.charAt(i)).add(s.charAt(i+1));
                        }
                }
            }
            if(sb.length()> 1) {
                String s = sb.toString();
                for (int i = 0; i < s.length() - 1; i++) {
                    if (s.charAt(i) != s.charAt(i + 1))
                        map.get(s.charAt(i)).add(s.charAt(i + 1));
                }
            }


//            for(String s: words){
//                for(int i=0; i<s.length()-1; i++){
//                    if(s.charAt(i)!= s.charAt(i+1))
//                    map.get(s.charAt(i)).add(s.charAt(i+1));
//                }
//            }
        }
    }

    public static void main(String args[]){

        System.out.println(" Program on topo Sort ");

        String [] words = {"wrt","wrf","er","ett","rftt"};
        //String [] words = {"z","x","z"};
        String s = alienOrder(words);
        System.out.println(s);

    }

    public static String alienOrder(String[] words) {

        Set<Character> uniqueValues = new HashSet<Character>();
        for(String s : words){
            for(Character c : s.toCharArray()){
                uniqueValues.add(c);
            }
        }
        Graph g = new Graph(uniqueValues);
        g.addEdge(words);
        System.out.println("The Map " + Graph.map.toString());


        //Step 1  check if it has cycle

        if(hasCycle(uniqueValues)){
            System.out.println("Since it has cycle cannot proceed ");
            return "";
        }else{
            System.out.println("Doest have cycle so proceed to topo sort ");
        }

        //Step 2 do the Topo Sort
        return new String();
    }

    public static boolean hasCycle(Set<Character> uniqueSet){

        Set<Character> greySet = new HashSet();
        Set<Character> blackSet = new HashSet();

        for(Character c: uniqueSet){
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

        for(Character child : Graph.map.get(val)){
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

}