package dfs;

import java.util.*;

public class CombinationSumImprovised {

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
        dfs(candidates, target, 0, new ArrayList<Integer>(), result);

        return result;
    }
    public static void dfs(int [] candidates, int target, int index, List<Integer> current, List<List<Integer>>result ){

        if(target == 0){
            result.add(new ArrayList(current));
        }
        if( target <0){
            return;
        }

        for(int i=index; i<candidates.length; i++){
            current.add(candidates[i]);
            dfs(candidates,target-candidates[i], i,current,result);
            current.remove(current.size()-1);
        }
    }
}
