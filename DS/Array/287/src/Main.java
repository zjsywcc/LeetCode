public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate2(nums));
    }


    // stupid
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if(nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // D & C
    public static int findDuplicate1(int[] nums) {
        int len = nums.length;
        int min = 1;
        int max = nums.length - 1;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for(int i = 0; i < len; i++) {
                if(nums[i] <= mid) {
                    count++;
                }
            }
            if(count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    // slow fast pointer
    public static int findDuplicate2(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }



}
