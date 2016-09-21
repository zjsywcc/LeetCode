import java.util.Arrays;
import java.util.List;

public class Main {

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(new Integer[]{1,1,2,3,3}));
        traverse(head);
        ListNode newHead = deleteDuplicates(head);
        traverse(newHead);
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
