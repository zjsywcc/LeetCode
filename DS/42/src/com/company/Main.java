package com.company;

public class Main {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int lh = height[l];
        int rh = height[r];
        int sum = 0;
        while(l != r) {
            if(height[l] < height[r]) {
                if (lh >= height[l]) {
                    sum += lh - height[l];
                    lh = Integer.max(height[l], lh);
                    l++;
                } else {
                    lh = Integer.max(height[l], lh);
                    l++;
                }
            } else {
                if (rh >= height[r]) {
                    sum += rh - height[r];
                    rh = Integer.max(height[r], rh);
                    r--;
                } else {
                    rh = Integer.max(height[r], rh);
                    r--;
                }
            }
        }
        return sum;
    }
}
