public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        int[] nums1 = new int[]{3,2,1,0,4};
        int[] nums2 = new int[]{1,0,1,0};
        System.out.println(canJump(nums1));
    }


    //TODO to think about how to reduce the space cost
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        if(len == 1) {
            return true;
        }
        int local[] = new int[len-1];
        int global[] = new int[len-1];
        local[0] = nums[0];
        global[0] = nums[0];
        for(int i = 1; i < len - 1; i++) {
            if(local[i-1] >= i) {
                local[i] = Math.max(local[i-1], i+nums[i]);
            } else {
                local[i] = local[i-1];
            }
            global[i] = Math.max(global[i-1], local[i]);
        }
        if(global[len-2] >= len - 1) {
            return true;
        } else {
            return false;
        }
    }
}
