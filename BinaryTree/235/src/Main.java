import java.util.Arrays;
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
        List<String> treeList = Arrays.asList(new String[]{"6","2","8","0","4","7","9","#","#","3","5"});
        TreeNode head = createTree(treeList);
        TreeNode p = getNodeByValue(head, 3);
        TreeNode q = getNodeByValue(head, 5);
//        traverse(head);
        System.out.println(p.val);
        System.out.println(q.val);
        System.out.println(lowestCommonAncestor(head, p, q).val);
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

    public static TreeNode getNodeByValue(TreeNode root, int value) {
        if(root == null) {
            return null;
        }
        if(root.val == value) {
            return root;
        }
        TreeNode lNode = getNodeByValue(root.left, value);
        TreeNode rNode = getNodeByValue(root.right, value);
        if(lNode != null) {
            return lNode;
        } else {
            return rNode;
        }
    }

    public static void traverse(TreeNode root) {
        if(root != null) {
            System.out.print(root.val+" ");
            traverse(root.left);
            traverse(root.right);
        }
    }



    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        return null;
    }


}
