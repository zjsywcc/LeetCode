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
        printList(postorderTraversal2(node1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Recursion version
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        helper(rst, root);
        return rst;
    }

    public static void helper(List<Integer> rst, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(rst, root.left);
        helper(rst, root.right);
        rst.add(root.val);
    }

    // two stacks
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode crt = s1.peek();
            s2.push(crt);
            s1.pop();
            if (crt.left != null) {
                s1.push(crt.left);
            }
            if (crt.right != null) {
                s1.push(crt.right);
            }
        }
        while (!s2.isEmpty()) {
            TreeNode crt = s2.pop();
            rst.add(crt.val);
        }
        return rst;
    }

    // one stack
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> postorder = new Stack<TreeNode>();
        postorder.push(root);
        TreeNode prev = null;
        while (!postorder.isEmpty()) {
            TreeNode crt = postorder.peek();
            if (prev == null || prev.left == crt || prev.right == crt) {
                if (crt.left != null) {
                    postorder.push(crt.left);
                } else if (crt.right != null) {
                    postorder.push(crt.right);
                }
            } else if (crt.left == prev) {
                if (crt.right != null) {
                    postorder.push(crt.right);
                }
            } else {
                rst.add(crt.val);
                postorder.pop();
            }
            prev = crt;
        }
        return rst;
    }


    public static void printList(List<Integer> rst) {
        for (int i : rst) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
