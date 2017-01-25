import java.util.Arrays;
import java.util.List;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class NodeNIndex {
        TreeNode head;
        ListNode tail;

        public NodeNIndex(TreeNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        ListNode node = createList(Arrays.asList(new Integer[] {1,2,3,4,5,6}));
        TreeNode treeNode = sortedListToBST(node);
        inorderTraverse(treeNode);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        int size = getLength(head);
        return reverse(size).head;
    }

    public static NodeNIndex reverse(int size) {
        if(size <= 0) {
            return null;
        }
        NodeNIndex left = reverse(size / 2);
        TreeNode leftHead = left.head;
        TreeNode root = new TreeNode(left.tail.next.val);
        NodeNIndex right = reverse(size - size / 2 -1);
        TreeNode rightHead = right.head;
        root.left = leftHead;
        root.right = rightHead;
        return new NodeNIndex(root, right.tail);
    }

    public static int getLength(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static ListNode createList(List<Integer> list) {
        if(list == null || list.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode prev = head;
        for(int i = 1; i < list.size(); i++) {
            ListNode crt = new ListNode(list.get(i));
            prev.next = crt;
            prev = crt;
        }
        prev.next = null;
        return head;
    }

    public static void inorderTraverse(TreeNode node) {
        if(node == null) {
            return;
        }
        inorderTraverse(node.left);
        System.out.print(node.val+" ");
        inorderTraverse(node.right);
    }
}
