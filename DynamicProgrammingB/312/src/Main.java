import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] values = new int[]{4, 1, 5 ,10};
        int[] values1 = new int[]{3, 1, 5 ,8};
        System.out.println(maxCoins(values));
        System.out.println(maxCoins(values1));
    }

    public static int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if(len == 1) {
            return nums[0];
        }
        int[] values = new int[len + 2];
        for(int i = 0; i < len + 2; i++) {
            if(i == 0 || i == len + 1) {
                values[i] = 1;
            } else {
                values[i] = nums[i - 1];
            }
        }
        int[][] dp = new int[len + 2][len + 2];
        boolean[][] flag = new boolean[len + 2][len + 2];
        return MemorySearch(1, len, dp, values, flag);
    }

    public static int MemorySearch(int i, int j, int[][] dp, int[] values, boolean[][] flag) {
        if(flag[i][j]) {
            return dp[i][j];
        }
        int max = 0;
        for(int k = i; k <= j; k++) {
            int x = values[i - 1] * values[k] * values[j + 1];
            int left = MemorySearch(i, k - 1, dp, values, flag);
            int right = MemorySearch(k + 1, j, dp, values, flag);
            max = Math.max(max, left + right + x);
        }
        flag[i][j] = true;
        dp[i][j] = max;
        return dp[i][j];
    }
}
