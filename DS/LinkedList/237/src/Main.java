public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        if(node == null || node.next == null) {
            return;
        }
        ListNode nodeNext = node.next;
        ListNode tempTail = nodeNext.next;

    }

    public static void printNodes(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
