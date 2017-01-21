public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(removeElement(nums, 1));
        printArray(nums);
    }

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int count = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < len && end < len && start < len; i++) {
            if(nums[i] == val) {
                count++;
                end++;
            } else {
                if(start != end) {
                    nums[start] = nums[end];
                }
                start++;
                end++;
            }
        }
        return len - count;
    }

    public static void printArray(int[] nums) {
        for(int i : nums) {
            System.out.print(i);
        }
        System.out.println();
    }
}
