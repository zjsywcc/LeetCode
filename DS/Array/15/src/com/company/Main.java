package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[]{0, 0, 0};
        int[] nums2 = new int[]{-2, 0, 0, 2, 2};
        printLists(threeSum(nums2));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return lists;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int current;
        for(int i = 0; i < len - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                current = a + nums[j] + nums[k];
                if (current == 0) {
                    List<Integer> solution = new ArrayList<Integer>();
                    solution.add(nums[i]);
                    solution.add(nums[j]);
                    solution.add(nums[k]);
                    lists.add(solution);
                    j++;
                    k--;
                    while(j < len && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while(k >= 0 &&  nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if(current < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return lists;
    }

    public static void printLists(List<List<Integer>> lists) {
        for(List<Integer> list : lists) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void printList(int[] list) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
    }
}
