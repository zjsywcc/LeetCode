package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public static void main(String[] args) {
        RandomListNode head = createList(Arrays.asList(new Integer[]{2, 1, 5, 4, 3}));
        traverse(head);
    }

    //TODO 1.one pass hash 2.without hash
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newRandomListNode = createList(head, map);
        RandomListNode node = head;
        while(node != null) {
            RandomListNode random = node.random;
            if(random != null) {
                map.get(node).random = map.get(random);
            } else {
                map.get(node).random = null;
            }
            node = node.next;
        }
        return newRandomListNode;
    }

    public static void traverse(RandomListNode head) {
        while(head != null) {
            System.out.print(head.label+" ");
            head = head.next;
        }
    }

    public static RandomListNode createList(RandomListNode node, HashMap<RandomListNode, RandomListNode> map) {
        if(node == null) {
            return null;
        }
        RandomListNode dummyNode = new RandomListNode(-1);
        RandomListNode prev = dummyNode;
        RandomListNode crt = node;
        while(crt != null) {
            RandomListNode temp = new RandomListNode(crt.label);
            prev.next = temp;
            map.put(crt, temp);
            crt = crt.next;
            prev = temp;
        }
        prev.next = null;
        return dummyNode.next;
    }

    public static RandomListNode createList(List<Integer> list) {
        if(list == null || list.isEmpty()) {
            return null;
        }
        RandomListNode head = new RandomListNode(list.get(0));
        RandomListNode prev = head;
        for(int i = 1; i < list.size(); i++) {
            RandomListNode crt = new RandomListNode(list.get(i));
            prev.next = crt;
            prev = crt;
        }
        prev.next = null;
        return head;
    }
}
