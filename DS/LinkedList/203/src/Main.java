public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        printNodes(node1);
        printNodes(removeElements(node1, 1));
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode crt = head;
        while(crt != null) {
            if(crt.val == val) {
                pre.next = crt.next;
                crt = crt.next;
            } else {
                pre = pre.next;
                crt = crt.next;
            }
        }
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
