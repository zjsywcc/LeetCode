import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left ;
        TreeNode right ;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public TreeNode createTree(List<String> treeList) {
        if(treeList == null || treeList.size() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int index = 0;
        TreeNode head = generateNode(treeList.get(index++));
        if(head != null)
            queue.offer(head);
        while(!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            
        }
    }

    public TreeNode generateNode(String str) {
        if(str.equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(str));
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        if(isChild(root.left, p) && isChild(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(isChild(root.right, p) && isChild(root.right, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public boolean isChild(TreeNode root, TreeNode child) {
        if(root == null) {
            return false;
        }
        if(child == null) {
            return true;
        }
        if(root == child || root.left == child || root.right == child) {
            return true;
        }
        return isChild(root.left, child) || isChild(root.right, child);
    }
}
