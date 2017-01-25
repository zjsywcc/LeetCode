public class Main {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        printNodes(node1);
        printNodes(insertionSortList(node1));
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode crt = head;
        ListNode next = head.next;
        while(next != null) {
            ListNode insertPrev = dummyNode;
            ListNode insertCrt = dummyNode.next;
            if (crt.val > next.val) {
                while(insertCrt.val < next.val && insertCrt.next != null) {
                    insertPrev = insertPrev.next;
                    insertCrt = insertCrt.next;
                }
                crt.next = next.next;
                insertPrev.next = next;
                next.next = insertCrt;
//                System.out.printf("insert %d after %d before %d\n", next.val, insertPrev.val,
//                        insertCrt.val);

                next = crt.next;

            } else {
                crt = crt.next;
                next = crt.next;
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
