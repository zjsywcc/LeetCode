package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean flag = false;
        for(int i : nums) {
            if(map.get(i) == null) {
                map.put(i, 1);
            } else {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
