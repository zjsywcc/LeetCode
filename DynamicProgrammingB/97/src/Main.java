public class Main {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
        System.out.println(isInterleave(s1, s2, s4));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len3 != len1 + len2) {
            return false;
        }
        boolean[][]dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 1; i < len1 + 1; i++) {
            if(s1.substring(0, i).equals(s3.substring(0, i))) {
                dp[i][0] = true;
            } else {
                dp[i][0] = false;
            }
        }
        for(int j = 1; j < len2 + 1; j++) {
            if(s2.substring(0, j).equals(s3.substring(0, j))) {
                dp[0][j] = true;
            } else {
                dp[0][j] = false;
            }
        }
        for(int i = 1; i < len1 + 1; i++) {
            for(int j = 1; j < len2 + 1; j++) {
                dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
//        for(int i = 0; i < len1 + 1; i++) {
//            for (int j = 0; j < len2 + 1; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[len1][len2];
    }
}
