public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
//        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
        System.out.println(isPalindrome(node1));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // still can optimize use fast-slow pointers to find the middle and use dedicate function to reverse the linked list
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode crt = head;
        int len = 0;
        while (crt != null) {
            crt = crt.next;
            len++;
        }
        int halfLen = len / 2;
        if (len % 2 == 1) {
            halfLen++;
        }
//        System.out.println(halfLen);
        ListNode pre = dummyHead;
        while (halfLen > 0) {
            pre = pre.next;
            halfLen--;
        }
        ListNode preNext = pre.next;
        ListNode next = preNext;
        while (next.next != null) {
            ListNode exchange = next.next;
            ListNode tempTail = exchange.next;
            pre.next = exchange;
            exchange.next = preNext;
            next.next = tempTail;
//            printNodes(dummyHead.next);
            preNext = pre.next;
        }
//        printNodes(dummyHead.next);
        ListNode crt1 = dummyHead.next;
        ListNode crt2 = pre.next;
        while (crt1 != null && crt2 != null && crt1.val == crt2.val) {
            crt1 = crt1.next;
            crt2 = crt2.next;
        }
        if (crt2 != null) {
            return false;
        }
        return true;
    }

    public static void printNodes(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        prev.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        return prev;
    }
}
