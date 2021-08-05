package dfs;

import java.util.*;
public class SerializeAndDeserializeBinaryTree {

    public static class TreeNode {

        int val;
        TreeNode left, right;
        public TreeNode(int n ){
            this.val = n;
            left = null;
            right = null;
        }
    }

    public static void main(String args[]){

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String sb = serialize(root);
        System.out.println(sb);

        TreeNode anotherRoot = deserialize(Arrays.stream(sb.split(" ")).iterator());
        System.out.println(" The root node is " + anotherRoot.val);

    }

    public static TreeNode deserialize(Iterator<String> itr){
        String s = itr.next();
        if(s.equals("x")) return null;
                TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = deserialize(itr);
            node.right = deserialize(itr);
        return node;
    }

    public static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }

    public static void dfs(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("x");
            sb.append(" ");
            return;
        }
        sb.append(Integer.toString(root.val));
        sb.append(" ");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }
}
