import java.util.HashSet;


public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2, 5, 7, 6, 8};
        int[] nums1 = new int[]{6, 8, 7, 5, 4};
        int[] nums2 = new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(longestConsecutive(nums2));
    }

    public static int longestConsecutive(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            int down = nums[i];
            while(set.contains(down)) {
                set.remove(down);
                down -= 1;
            }
            int up = nums[i];
            while(set.contains(up+1)) {
                set.remove(up + 1);
                up += 1;
            }
            if(up - down > max) {
                max = up - down;
            }
        }
        return max;
    }


}
