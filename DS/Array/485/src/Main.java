public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            if(i == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
