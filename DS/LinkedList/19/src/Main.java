public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printNodes(node1);
        printNodes(removeNthFromEnd(node1, 1));
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        if(head == null) {
            return null;
        }
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode latter = dummyHead;
        int count = n;
        while(count >= 0) {
            if(latter == null) {
                return head;
            }
            latter = latter.next;
            count--;
        }
        while(latter != null) {
            pre = pre.next;
            latter = latter.next;
        }
        if(pre == dummyHead) {
            dummyHead.next = dummyHead.next.next;
            return dummyHead.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }

    public static void printNodes(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
