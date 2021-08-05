package dfs;

public class LCA {

    public static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int x){
            this.val = x;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode node = lowestCommonAncestor(root,root.left,root.left.right);
        System.out.println(" LCA " + node.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        return root;
    }
}
