public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        printNodes(node1);
        printNodes(rotateRight(node1, 12));
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        int count = k;
        ListNode pre = dummyNode;
        ListNode crt = pre;
        while(count > 0 && crt.next != null) {
            crt = crt.next;
            count--;
        }
        if(count == 0 && crt.next == null) {
            return head;
        }
        if(count > 0) {
            count = count % (k - count);
            if(count == 0) {
                return head;
            }
            pre = dummyNode;
            crt = pre;
            while(count > 0 && crt.next != null) {
                crt = crt.next;
                count--;
            }
        }
        while(crt.next != null) {
            pre = pre.next;
            crt = crt.next;
        }
        ListNode tempHead = dummyNode.next;
        dummyNode.next = pre.next;
        crt.next = tempHead;
        pre.next = null;
        return dummyNode.next;
    }

    public static void printNodes(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
