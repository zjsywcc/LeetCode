public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
