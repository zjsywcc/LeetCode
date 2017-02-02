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
        printList(preorderTraversal(node1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<Integer> preorderList = new ArrayList<Integer>();


    // Recursion version
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preorderList.add(root.val);
            if (root.left != null) {
                preorderTraversal(root.left);
            }
            if (root.right != null) {
                preorderTraversal(root.right);
            }
        }
        return preorderList;
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null) {
            return rst;
        }
        Stack<TreeNode> preorder = new Stack<TreeNode>();
        preorder.push(root);
        while(!preorder.isEmpty()) {
            TreeNode node = preorder.pop();
            rst.add(node.val);
            if(node.right != null) {
                preorder.push(node.right);
            }
            if(node.left != null) {
                preorder.push(node.left);
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
