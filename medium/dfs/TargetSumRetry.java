package dfs;

public class TargetSumRetry {

    public static void main(String args[]){

        System.out.println("Trying program with 1 symbol and adding it to nums");

        int [] nums = {1,1,1,1,1};
        String [] symbols = new String[] {"+", "-"};
        //Possibly create and expression first

        for(String s : symbols) {
            createExpression(nums, s);
        }

    }

    public static String createExpression(int [] nums, String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            sb.append(s);
            sb.append(nums[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
