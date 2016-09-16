public class Main {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums[0] >= target) {
            return 0;
        }
        if(nums[nums.length - 1] < target) {
            return nums.length;
        }
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[start] < target) {
            return start +1;
        } else {
            return start;
        }
    }
}
