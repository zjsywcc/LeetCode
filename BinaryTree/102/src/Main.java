import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left ;
        TreeNode right ;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if(treeNode.left != null)
                    queue.offer(treeNode.left);
                if(treeNode.right != null)
                    queue.offer(treeNode.right);
            }
            lists.add(list);
        }
        return lists;
    }
}
