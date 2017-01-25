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
        ListNode newHead = reverseList2(head);
        traverse(newHead);
    }

    public static ListNode reverseList2(ListNode head) {
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

    /*
    * reverse version
    * */
    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        return reverse(dummy, dummy.next);
    }

    public static ListNode reverse(ListNode prev, ListNode next) {
        if(next == null) {
            return prev;
        }
        if(prev.val == Integer.MIN_VALUE) {
            prev = null;
        }
        ListNode temp = next.next;
        next.next = prev;
        return reverse(next, temp);
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
