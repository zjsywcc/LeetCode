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
        int[] preorder = new int[]{1, 2, 4, 5, 3};
        traversePreOrder(buildTree(preorder, inoder));
        traverseInOrder(buildTree(preorder, inoder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int inLen = inorder.length;
        int preLen = preorder.length;
        if (inLen != preLen) {
            return null;
        }
        return helper(inorder, 0, inLen - 1,
                preorder, 0, preLen - 1, map);
    }

    public static TreeNode helper(int[] inOrder, int inStart, int inEnd,
                                  int[] preOrder, int preStart, int preEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int position = map.get(preOrder[preStart]);
        root.left = helper(inOrder, inStart, position - 1,
                preOrder, preStart + 1, preStart + position - inStart, map);
        root.right = helper(inOrder, position + 1, inEnd,
                preOrder, preStart + position - inStart + 1, preEnd, map);
//        root.right = helper(inOrder, position + 1, inEnd,
//                preOrder, position - inEnd + preEnd + 1, preEnd, map);
        return root;
    }

    public static void traversePreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "  ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
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
