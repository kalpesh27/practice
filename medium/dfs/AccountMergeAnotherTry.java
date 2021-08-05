package dfs;

import java.util.ArrayList;
import java.util.*;

public class AccountMergeAnotherTry {

        public static class DSU{
            int [] parent ;
            public DSU(){
                parent = new int [10001];
                for(int i =0;i <parent.length; i++){
                    parent[i] = i;
                }
            }

            public int find(int x){
                if(parent[x] != x){
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int x, int y){
                parent[find(x)] = find(y);
            }

        }



        public static List<List<String>> accountsMerge(List<List<String>> accounts) {
            List<List<String>> result = new ArrayList<>();

            DSU dsu = new DSU();
            HashMap<String, String> emailToName = new HashMap<>();
            HashMap<String, Integer> emailToId =  new HashMap<>();
            int id = 0;
            for(List<String> account : accounts){
                // For each account we need to get the email to name mapping
                String name = "";
                for(String email : account){
                    if(name == ""){
                        name = email;
                        continue;
                    }
                    emailToName.put(email,name);
                    if(!emailToId.containsKey(email)){
                        emailToId.put(email,id++);
                    }
                    dsu.union(emailToId.get(account.get(1)), emailToId.get(email));
                }
            }

            // Third Step is to create the result List<List<String>> which is the result of Name , chain of connected Emails.

            HashMap<Integer, List<String>> ans = new HashMap();
            for(String email : emailToName.keySet()){
                //Get the email and find its parent value
                int index = emailToId.get(email);
                int i = dsu.find(index);
                ans.computeIfAbsent(i, x -> new ArrayList<>()).add(email);
            }

            for(List<String> list : ans.values()){
                Collections.sort(list);
                list.add(0,emailToName.get(list.get(0)));
                result.add(list);
            }
            return result;
        }

        public static void main(String args[]) {
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
}
