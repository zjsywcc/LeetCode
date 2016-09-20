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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for(int i = 0; i < lists.size(); i++) {
            if(i % 2 == 1) {
                lists.set(i, reverseList(lists.get(i)));
            }
        }
        return lists;
    }

    public static List<Integer> reverseList(List<Integer> list) {
        List<Integer> new_list = new ArrayList<Integer>();
        for(int i = list.size() - 1; i >= 0; i--) {
            new_list.add(list.get(i));
        }
        return new_list;
    }
}
