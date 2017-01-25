public class Main {

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        int len1 = s.length();
        int len2 = t.length();
        if(len1 < len2) return 0;
        if(len2 == 0) return 1;
        int[][] dp = new int[len1 + 1][len2 + 1];
//        for(int i = 0; i < len1 + 1; i++) {
//            dp[i][0] = -2;
//        }
        dp[0][0] = 1;
        for(int i = 1; i < len1 + 1; i++) {
            for(int j = 1; j < len2 + 1; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
