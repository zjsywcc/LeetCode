package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int[] candidates = new int[]{7,5,8,12,3,10,9,4,11,6};
//        int target = 21;
        int[] candidates = new int[]{2, 2, 3}; // isn't a set
        int target = 7;
        printLists(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(len == 0) {
            return rst;
        }
        List<Integer> solution = new ArrayList<Integer>();
        int sum = 0;
        int lastAdded = -1;
        helper(rst, solution, candidates, target, sum, lastAdded);
        return rst;
    }

    public static void helper(List<List<Integer>> rst, List<Integer> solution, int[] candidates, int target, int sum, int lastAdded) {
        if(sum == target) {
            List<Integer> sorted = new ArrayList<Integer>(solution);
            Collections.sort(sorted);
            if (!rst.contains(sorted)) {
                rst.add(sorted);
            }
            return;
        }
        if(sum > target) {
            return;
        }
        for(int i = 0; i < candidates.length; i++) {
            if(lastAdded > i) {
                continue;
            }
            solution.add(candidates[i]);
            helper(rst, solution, candidates, target, sum + candidates[i], i);
            solution.remove(solution.size() - 1);
        }
    }

    public static void printLists(List<List<Integer>> rst) {
        System.out.println("size of results: " + rst.size());
        for(List<Integer> list : rst) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void printList(List<Integer> list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
