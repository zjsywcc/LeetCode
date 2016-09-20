public class Main {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public boolean isBalanced(TreeNode root) {
        return maxHeight(root) >= 0;
    }

    public int maxHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);
        if(lh == -1 || rh == -1 || Math.abs(lh - rh) >= 1) {
            return -1;
        }
        return Math.max(lh ,rh) + 1;
    }
}
