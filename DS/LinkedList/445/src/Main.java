public class Main {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        ListNode node14 = new ListNode(9);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(1);
        ListNode node23 = new ListNode(1);
        node21.next = node22;
        node22.next = node23;
        printNodes(addTwoNumbers(node11, node21));
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode crt1 = l1;
        String str1 = "";
        ListNode crt2 = l2;
        String str2 = "";
        while(crt1 != null) {
            str1 += crt1.val;
            crt1 = crt1.next;
        }
        while(crt2 != null) {
            str2 += crt2.val;
            crt2 = crt2.next;
        }
        int size1 = str1.length();
        int size2 = str2.length();
        int add = 0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;
        int i, j;
        for(i = size1 - 1, j = size2 - 1; i >= 0 && j >= 0; i--, j--) {
            int sum = str1.charAt(i) - '0' + str2.charAt(j) - '0' + add;
            if(sum > 9) {
                sum %= 10;
                add = 1;
            } else {
                add = 0;
            }
            ListNode crt = new ListNode(sum);
            ListNode tempTail = dummyHead.next;
            dummyHead.next = crt;
            crt.next = tempTail;
        }
        for(; i >= 0; i--) {
            int sum = str1.charAt(i) - '0' + add;
            if(sum > 9) {
                sum %= 10;
                add = 1;
            } else {
                add = 0;
            }
            ListNode crt = new ListNode(sum);
            ListNode tempTail = dummyHead.next;
            dummyHead.next = crt;
            crt.next = tempTail;
        }
        for(; j >= 0; j--) {
            int sum = str2.charAt(j) - '0' + add;
            if(sum > 9) {
                sum %= 10;
                add = 1;
            } else {
                add = 0;
            }
            ListNode crt = new ListNode(sum);
            ListNode tempTail = dummyHead.next;
            dummyHead.next = crt;
            crt.next = tempTail;
        }
        if(add == 1) {
            ListNode crt = new ListNode(1);
            ListNode tempTail = dummyHead.next;
            dummyHead.next = crt;
            crt.next = tempTail;
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
