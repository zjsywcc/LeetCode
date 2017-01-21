import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums1 = new int[]{0,2,1,-3};
        int[] nums2 = new int[]{1,1,-1,-1,3};
        System.out.println(threeSumClosest(nums2, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return -1;
        }
        int len = nums.length;
        int threeSum = Integer.MAX_VALUE >> 1;
        int current = threeSum;
        Arrays.sort(nums);
        for(int i = 0; i < len - 1; i++) {
            int a = nums[i];
            int j = i + 1;
            int k = len - 1;
            while(j < k) {
                current = a + nums[j] + nums[k];
                if (Math.abs(current - target) < Math.abs(threeSum - target)) {
                    threeSum = current;
                }
                if(current < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return threeSum;
    }
}
