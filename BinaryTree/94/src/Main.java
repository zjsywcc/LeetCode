import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        printList(inorderTraversal(node1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // non-recursion version
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null) {
            return rst;
        }
        Stack<TreeNode> inorder = new Stack<TreeNode>();
        while(root != null || !inorder.isEmpty()) {
            while(root != null) {
                inorder.push(root);
                root = root.left;
            }
            if(!inorder.isEmpty()) {
                root = inorder.pop();
                rst.add(root.val);
                root = root.right;
            }
        }
        return rst;
    }

    public static void printList(List<Integer> rst) {
        for(int i : rst) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
