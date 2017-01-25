public class Main {

    public static void main(String[] args) {
        String str = "aabcdc";
        System.out.println(minCut(str));
    }

    public static int minCut(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 0;
        boolean[][] flag = isPalindrome(s);
        for(int i = 1; i < len + 1; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(flag[j][i-1]) {
                    if(dp[j] < min) {
                        min = dp[j] + 1;
                    }
                }
            }
            dp[i] = min;
        }
        return dp[len] - 1;
    }

    public static boolean[][] isPalindrome(String s) {
        int len = s.length();
        boolean[][] flag = new boolean[len][len];
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if(i == j) {
                    flag[i][j] = true;
                } else if(i + 1 == j) {
                    flag[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    flag[i][j] = s.charAt(i) == s.charAt(j) && flag[i + 1][j - 1];
                }
            }
        }
        return flag;
    }
}
