import java.util.Arrays;
import java.util.List;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        traverse(head);
        ListNode newHead = reverseBetween(head, 4, 5);
        traverse(newHead);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode tempHead = dummyNode;
        dummyNode.next = head;
        int i;
        for(i = 1; i < m; i++) {
            tempHead = head;
            head = head.next;
        }
        ListNode prev = head;
        ListNode tempHeadIn = prev;
        ListNode next = head.next;
        for(; i < n; i++) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        ListNode tempTailIn = prev;
        ListNode tempTail = next;
        tempHeadIn.next = tempTail;
        tempHead.next = tempTailIn;
        return dummyNode.next;
    }

    public static void traverse(ListNode head) {
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
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
}
