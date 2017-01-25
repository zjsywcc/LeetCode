public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int index = 0;
        for(int i : nums) {
            if(i != 0) {
                nums[index++] = i;
            }
        }
        for(; index < len; index++) {
            nums[index] = 0;
        }
    }
}
