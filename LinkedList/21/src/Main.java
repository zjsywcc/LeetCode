import java.util.Arrays;
import java.util.List;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(new Integer[]{1, 3, 5}));
        traverse(head);
        ListNode head2 = createList(Arrays.asList(new Integer[]{2, 4, 6}));
        traverse(head2);
        ListNode newHead = mergeTwoLists(head, head2);
        traverse(newHead);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode crt1 = l1;
        ListNode crt2 = l2;
        ListNode crt = dummyHead;
        while(crt1 != null && crt2 != null) {
            if(crt1.val < crt2.val) {
                crt.next = crt1;
                crt = crt1;
                crt1 = crt1.next;
            } else {
                crt.next = crt2;
                crt = crt2;
                crt2 = crt2.next;
            }
        }
        if(crt1 == null) {
            crt.next = crt2;
        }
        if(crt2 == null) {
            crt.next = crt1;
        }
        return dummyHead.next;
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
