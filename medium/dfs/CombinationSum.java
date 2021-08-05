package dfs;
import java.util.*;

public class CombinationSum {

    public static void main(String args[]){
        System.out.println("Program on combination sum ");
        //int [] candidates = {2,3,6,7};
        int [] candidates = {1,2};
        int target = 4;
        List<List<Integer>> result = combinationSum(candidates,target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList<>();
        dfs(result, candidates, current, target,0);

        return result;
    }

    public static void dfs(List<List<Integer>> result, int [] candidates, List<Integer> current, int target, int index){
        if(calculateCurrent(current) == target){
            //Collections.sort(current);
//            if(!result.contains(current)) {
                result.add(new ArrayList(current));
//            }
            return;
        }else if(calculateCurrent(current) > target){
            return;
        }

        for(int i =index; i<candidates.length; i++){
            current.add(candidates[i]);
            dfs(result,candidates,current, target,i);
            current.remove(current.size()-1);
        }
    }

    public static int calculateCurrent(List<Integer> current){

        int total =0;
        for(int i :current){
            total = total + i;
        }
        return total;
    }

}
