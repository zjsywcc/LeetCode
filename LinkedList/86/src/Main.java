import java.util.Arrays;
import java.util.List;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(new Integer[]{1, 4, 3, 2, 5, 2}));
        traverse(head);
        ListNode newHead = partition(head, 3);
        traverse(newHead);
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode crt = dummyHead;
        while(crt != null && crt.val < x) {
            prev = crt;
            crt = crt.next;
        }
        ListNode next = crt;
        ListNode tempTail = crt;
        while(next != null) {
            if(next.val >= x) {
                tempTail = next;
                next = next.next;
            } else {
                ListNode temp1 = prev.next;
                ListNode temp2 = next.next;
                prev.next = next;
                next.next = temp1;
                tempTail.next = temp2;
                prev = next;
                next = temp2;
            }
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
