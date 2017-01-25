public class Main {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(8);
        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        c1.next = c2;
        c2.next = c3;
        System.out.println(getIntersectionNode(a1, a1).val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        if(headA == headB) {
            return headA;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        int lenA = 0;
        int lenB = 0;
        while(pA != null) {
            pA = pA.next;
            lenA++;
        }
        while(pB != null) {
            pB = pB.next;
            lenB++;
        }
        pA = headA;
        pB = headB;
        if(lenA > lenB) {
            int difAB = lenA - lenB;
            while(difAB > 0) {
                pA = pA.next;
                difAB--;
            }
        } else if(lenB > lenA) {
            int difBA = lenB - lenA;
            while(difBA > 0) {
                pB = pB.next;
                difBA--;
            }
        }
        while(pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}
