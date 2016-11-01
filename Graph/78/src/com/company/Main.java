package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<List<Integer>> subset = subset(new int[]{1, 2, 3});
        printLists(subset);
    }

    public static List<List<Integer>> subset(int[] nums) {
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null) {
            return rst;
        }

        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst, list, nums);
        List<Integer> array = new ArrayList<Integer>();
        for(int i : nums) {
            array.add(i);
        }
        Collections.sort(array);
        rst.add(array);
        return rst;
    }

    public static void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length) {
            return;
        }
        if(list.size() != nums.length) {
            rst.add(new ArrayList<Integer>(list));
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i]) || (list.size() > 0 && list.get(list.size() - 1) > nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(rst, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void printLists(List<List<Integer>> result) {
        for(List<Integer> list : result) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
