public class Main {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,3,4,6}));
    }

    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}
