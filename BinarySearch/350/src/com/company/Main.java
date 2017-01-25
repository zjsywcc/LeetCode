package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        int[] nums2 = {2, 2, 1};
        printList(intersect(nums1, nums2));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        int a = 0, b = 0;
        while(a < nums1.length && b < nums2.length) {
            if(nums1[a] < nums2[b]) {
                a++;
            } else if(nums1[a] > nums2[b]) {
                b++;
            } else {
                list.add(nums1[a]);
                a++;
                b++;
            }
        }
        int[] rst = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            rst[i] = list.get(i);
        }
        return rst;
    }


    public static void printList(int[] list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
