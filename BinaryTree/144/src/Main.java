import java.util.ArrayList;
import java.util.List;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    List<Integer> preorderList = new ArrayList<Integer>();
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null) {
            preorderList.add(root.val);
            if(root.left != null) {
                preorderTraversal(root.left);
            }
            if(root.right != null) {
                preorderTraversal(root.right);
            }
        }
        return preorderList;
    }
}
