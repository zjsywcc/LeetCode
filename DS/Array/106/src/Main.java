import java.util.HashMap;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] inoder = new int[]{4, 2, 5, 1, 3};
        int[] postorder = new int[]{4, 5, 2, 3, 1};
        traversePostOrder(buildTree(inoder, postorder));
        traverseInOrder(buildTree(inoder, postorder));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            return null;
        }
        return helper(inorder, 0, inLen - 1,
                postorder, 0, postLen - 1, map);
    }

    public static TreeNode helper(int[] inOrder, int inStart, int inEnd,
                                  int[] postOrder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int postion = map.get(postOrder[postEnd]);
        root.left = helper(inOrder, inStart, postion - 1,
                postOrder, postStart, postStart + postion - inStart - 1, map);
        root.right = helper(inOrder, postion + 1, inEnd,
                postOrder, postStart + postion - inStart, postEnd - 1, map);
        return root;
    }

    public static void traversePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.val + "  ");
    }

    public static void traverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.left);
        System.out.print(root.val + "  ");
        traverseInOrder(root.right);
    }

}
