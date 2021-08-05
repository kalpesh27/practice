package dfs;

public class TargetSum {

    public static void main(String args[]){

        System.out.println("The program on target sum can be solved using DFs");

        int [] nums = {1,1,1,1,1};
        int target = 3;
        int k = findTargetSumWays(nums,target);
        System.out.println(k);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int result =0;
        String [] symbols = new String []{"+", "-"};
        if(nums.length == 0) return result;
        //Call 2 dfs 1 with + and other with -1
        dfs(symbols[0],nums, target);
        dfs(symbols[1], nums, target);

        return result;
    }

    public static void dfs(String symbol , int [] nums, int target){


    }
}
