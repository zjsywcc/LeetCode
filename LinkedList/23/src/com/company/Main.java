package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    public static Comparator<ListNode> Comparator = new Comparator<ListNode>(){

        @Override
        public int compare(ListNode l1, ListNode l2) {
            return (int) (l1.val - l2.val);
        }
    };

    //TODO solution merge and solution merge two by two
    public static void main(String[] args) {
        ListNode head1 = createList(Arrays.asList(new Integer[]{1,3,5}));
        ListNode head2 = createList(Arrays.asList(new Integer[]{2,4,6}));
        ListNode head3 = createList(Arrays.asList(new Integer[]{1}));
        ListNode[] listNodes = new ListNode[]{head1, head2};
        ListNode[] listNodes1 = new ListNode[]{head3};
        ListNode newHead = mergeKLists(listNodes);
        traverse(newHead);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(Comparator);
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                queue.offer(lists[i]);
        }
        ListNode head = queue.poll();
        ListNode prev = head;
        if(head != null && head.next != null) {
            queue.offer(head.next);
        }
        while(!queue.isEmpty()) {
            ListNode crt = queue.poll();
            prev.next = crt;
            if(crt.next != null)
                queue.offer(crt.next);
            prev = crt;
        }
//        if(prev != null)
//            prev.next = null;
        return head;
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

    public static void traverse(ListNode head) {
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
