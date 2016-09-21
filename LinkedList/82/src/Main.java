public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        if(head == null) {
            return null;
        }
        ListNode next = head.next;
        while(next != null) {
            if(next.val == prev.val) {
                next = next.next;
            } else {
                prev.next = next;
                prev = next;
                next = next.next;
            }
        }
        prev.next = next;
        return head;
    }
}
