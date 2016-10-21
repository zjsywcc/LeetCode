package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        printLists(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int[] flag = new int[nums.length];
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(result, 0, path, nums, flag);
        return result;
    }

    public static void dfs(List<List<Integer>> result, int step, List<Integer> path, int[] nums, int[] flag) {
        if(step == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(flag[i] == 0) {
                if(i > 0 && nums[i] == nums[i - 1] && flag[i - 1] == 0) {
                    continue;
                }
                path.add(nums[i]);
                flag[i] = 1;
                dfs(result, step + 1, path, nums, flag);
                path.remove(path.size() - 1);
                flag[i] = 0;
            }
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
