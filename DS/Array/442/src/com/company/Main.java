package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        printList(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return rst;
        }
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                int left = i;
                int right = nums[left] - 1;
                while(nums[left] != left + 1) {
                    if(nums[left] == nums[right]) {
                        break;
                    }
                    swap(nums, left, right);
                    right = nums[left] - 1;
                }
            }
        }
        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                rst.add(nums[i]);
            }
        }
        return rst;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void printList(List<Integer> list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
