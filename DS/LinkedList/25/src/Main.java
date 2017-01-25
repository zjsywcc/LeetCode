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
        printNodes(reverseKGroup(node1, 1));
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        if(k <= 1) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode crt = head;
        ListNode next;
        ListNode latter;
        int count;
        while(crt != null) {
            count = k;
            latter = pre;
            while(count >= 0) {
                if(latter == null) {
                    break;
                }
                latter = latter.next;
                count--;
            }
//            System.out.printf("latter is %s\n", latter == null ? "null" : latter.val + "");
//            System.out.println(count);
            if(count >= 0) {
//                System.out.printf("latter's length is %d is less than k\n", k - count - 1);
                break;
            }
            ListNode tempCrt = crt;
            next = crt.next;
            crt.next = latter;
            count = k;
            while(count >= 2) {
                ListNode tempNext = next.next;
//                System.out.printf("insert %d after %d before %d\n", next.val, pre.val, crt.val);
                pre.next = next;
                next.next = crt;
//                System.out.printf("is %d before\n", next.val);
                crt = next;
//                System.out.printf("prepare to insert %d\n", tempNext.val);
                next = tempNext;

                count--;
            }
//            System.out.printf("move pre to %d\n", tempCrt.val);
            pre = tempCrt;
//            System.out.printf("move crt to %s\n", latter == null ? "null" : latter.val + "");
            crt = latter;
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
