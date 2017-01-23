public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] == len) {
                nums[i] = -1;
            } else if(nums[i] != i){
                int left = i;
                int right = nums[i];
                while(right >= 0 && right < len && nums[left] != left) {
                    if(nums[left] == nums[right]) {
                        break;
                    }
                    swap(nums, left, right);
                    right = nums[left];
                }
            }
        }
        for(int i = 0; i < len; i++) {
            if(i != nums[i]) {
                return i;
            }
        }
        return len;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
