import java.util.Arrays;
import java.util.List;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
        ListNode crt = head;
        ListNode temp = crt;
        ListNode tail = crt;
        while(crt != null) {
            if(crt.val == 3) {
                temp = crt;
            }
            if(crt.val == 6) {
                tail = crt;
                break;
            }
            crt = crt.next;
        }
        tail.next = temp;
        System.out.print("head: " + detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast != null && fast.next != null) {
            if(flag && slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
            flag = true;
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(fast != null) {
            if(fast == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
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
