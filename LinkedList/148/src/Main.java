import java.util.Arrays;
import java.util.List;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(new Integer[]{2, 1, 5, 4, 3}));
        traverse(head);
        ListNode newHead = sortList(head);
        traverse(newHead);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode rNode = sortList(mid.next);
        mid.next = null;
        ListNode lNode = sortList(head);
        return merge(lNode, rNode);
    }

    //TODO implement quick sort version
    public static ListNode quickSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode newHead = partition(head, mid.val);
        ListNode right = quickSortList(mid.next);
        mid.next = null;
        ListNode left = quickSortList(newHead);
        findTail(left).next = right;
        return left;
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

    public static ListNode findTail(ListNode node) {
        ListNode tail = null;
        return tail;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
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

    public static ListNode findMiddle(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
