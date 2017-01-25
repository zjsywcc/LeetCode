
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int[] nums1 = new int[]{3, 2, 1, 1, 1, 1, 2, 3};
        int[] nums2 = new int[]{2, 7, 1, 5};
        int[] nums3 = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        int[] nums4 = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen1(9, nums2));
    }

    //two pointer
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        int rst = Integer.MAX_VALUE;
        while(right < len) {
            while(sum < s && right < len) {
                sum += nums[right];
                right++;
            }
            if(sum < s && right == len && left == 0) {
                return 0;
            }
            rst = Math.min(rst, right - left);
            while(sum >= s && left < right) {
                sum -= nums[left];
                left++;
            }
            rst = Math.min(rst, right - left + 1);
        }
        return rst;
    }

    // binary search
    public static int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] sums = new int[len + 1];
        for(int i = 0; i < len + 1; i++) {
            if (i == 0) {
                sums[i] = 0;
            } else {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }
        int rst = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            int leftBound = leftBound(sums, s + sums[i]);
            // 上界溢出处理
            if(leftBound > len) {
                break;
            }
            System.out.println(leftBound);
            rst = Math.min(rst, leftBound - i);
        }
        if(rst == Integer.MAX_VALUE) {
            return 0;
        }
        return rst;
    }

    // >= s 的最小index
    public static int leftBound(int[] nums, int s) {
        int start = -1;
        int end = nums.length;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == s) {
                end = mid;
            } else if(nums[mid] > s) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start + 1;
    }


}
