package dfs;


import java.util.*;

public class TernaryTreePaths {

    public static class TreeNode{
        int val;
        TreeNode first,second,third;

        public TreeNode(int x){
            this.val = x;
            first = null;
            second =null;
            third = null;
        }
    }
    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.first = new TreeNode(2);
        root.first.first = new TreeNode(3);
        root.second = new TreeNode(4);
        root.third = new TreeNode(6);
        ternaryTreePaths(root);
    }
    public static void ternaryTreePaths(TreeNode root){
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        dfs(stack,root, list);

        System.out.println(list);
    }

    public static void dfs(Stack<Integer> stack, TreeNode root, List<String> list){
        if(root == null){
            return;
        }
        stack.add(root.val);
        if(root.first == null && root.second == null && root.third == null){
            StringBuilder sb = new StringBuilder();
            for(Integer i : stack){
                sb.append(i);
                sb.append("->");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            list.add(sb.toString());
        }

        dfs(stack,root.first,list);
        dfs(stack,root.second,list);
        dfs(stack,root.third,list);
        stack.pop();
    }
}
