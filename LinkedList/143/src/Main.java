import java.util.Arrays;
import java.util.List;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class pair {
        ListNode mid;
        ListNode tail;

        public pair(ListNode mid, ListNode tail) {
            this.mid = mid;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
        traverse(head);
        reorderList(head);
        traverse(head);
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = findMid(head).mid;
        ListNode tail = findMid(head).tail;
        ListNode newMidNext = reverseList(mid.next);
        mid.next = newMidNext;
        ListNode crt1 = head;
        ListNode crt2 = newMidNext;
        ListNode tempTail = crt2;
        while(crt2 != null) {
            ListNode temp1 = crt1.next;
            ListNode temp2 = crt2.next;
            tempTail = crt2;
            crt1.next = crt2;
            crt2.next = temp1;
            crt1 = temp1;
            crt2 = temp2;
        }
        if(tail == null) {
            mid.next = null;
        } else {
            tempTail.next = null;
        }
    }

    public static pair findMid(ListNode head) {
        if(head == null || head.next == null) {
            return new pair(head, null);
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return new pair(slow, fast);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        prev.next = null;
        while(next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        return prev;
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
