public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1 + 1; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < len2 + 1; j++) {
            dp[0][j] = 0;
        }
        int temp = 1;
        for(int j = 1; j < len2 + 1; j++) {
            for(int i = 1; i < len1 + 1; i++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + temp;
                } else {

                }
            }
        }
    }
}
