//package dfs;
//import java.util.*;
//
//public class PermutationsOfAString {
//
//    public static void main(String args[]){
//        System.out.println("PRint the combinations of a String ");
//        List<String> result =permute("abc");
//        System.out.println(result);
//
//    }
//
//    public static List<String> permute(String input){
//        List<String> result= new ArrayList<>();
//        dfs(input,result, "",0);
//        return result;
//    }
//
//    public static void dfs(String input, List<String> result, String current, int index){
//        if(index == input.length()){
//            result.add(current);
//            return;
//        }
//
//        for(int i=0; i<input.length(); i++){
//            if(current.contains(String.valueOf())){
//            }
//            dfs(input,result,current+input.charAt(i), index+1);
//        }
//
//    }
//}
