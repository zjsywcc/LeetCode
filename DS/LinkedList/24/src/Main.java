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
        printNodes(swapPairs(node1));
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead =  new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode crt = head;
        while(crt != null && crt.next != null) {
            ListNode latter = crt.next.next;
            pre.next = crt.next;
            crt.next.next = crt;
            crt.next = latter;
            pre = crt;
            crt = latter;
        }
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
