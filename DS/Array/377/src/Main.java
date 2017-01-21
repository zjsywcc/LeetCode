public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{9};
        int target = 3;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j : nums) {
                if(i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[target];
    }
}
