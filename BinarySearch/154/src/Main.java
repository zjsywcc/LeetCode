public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
