import java.util.*;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left ;
        TreeNode right ;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        List<String> treeList = Arrays.asList(new String[]{"1"});
        TreeNode head = createTree(treeList);
        System.out.println(isValidBST(head));
    }



    public static boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();
        traverse(root, list);
        int temp = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if(temp >= list.get(i)) {
                return false;
            }
            temp = list.get(i);
        }
        return true;
    }

    public static void traverse(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public static TreeNode createTree(List<String> treeList) {
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
            if(index < treeList.size()) {
                treeNode.left = generateNode(treeList.get(index++));
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
            }
            if(index < treeList.size()) {
                treeNode.right = generateNode(treeList.get(index++));
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return head;
    }

    public static TreeNode generateNode(String str) {
        if(str.equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(str));
        }
    }
}
