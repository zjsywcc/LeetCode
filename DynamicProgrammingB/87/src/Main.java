import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        String s3 = "rgtae";
        System.out.println(isScramble(s1, s2));
        System.out.println(isScramble(s1, s3));
    }

    //Pure recursively search version
    public static boolean isScramble1(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 != len2) {
            return false;
        } else if(!isValid(s1, s2)) {
            return false;
        }
        if(len1 == 0 || s1.equals(s2)) {
            return true;
        }
        for(int i = 1; i < len1; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, len1);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, len1);
            String s31 = s2.substring(0, len1 - i);
            String s32 = s2.substring(len1 - i, len1);
            if((isScramble1(s11, s21) && isScramble1(s12, s22)) ||
                    (isScramble1(s11, s32) && isScramble1(s12, s31))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if((new String(chars1)).equals(new String(chars2))) {
            return true;
        }
        return false;
    }

    //Recursive with memory search version
    public static boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 != len2) {
            return false;
        }
        int[][][] dp = new int[len1][len1][len1 + 1];
        return MemorySearch(0, 0, len1, dp, s1, s2);
    }

    public static boolean MemorySearch(int i, int j, int k, int[][][] dp, String s1, String s2) {
        if(dp[i][j][k] == 1) {
            return true;
        } else if(dp[i][j][k] == -1) {
            return false;
        }
        if(!isValid(s1, s2)) {
            dp[i][j][k] = -1;
            return false;
        }
        if(k == 0 || s1.equals(s2)) {
            dp[i][j][k] = 1;
            return true;
        }
        for(int x = 1; x < k; x++) {
            String s11 = s1.substring(0, x);
            String s12 = s1.substring(x, k);
            String s21 = s2.substring(0, x);
            String s22 = s2.substring(x, k);
            String s31 = s2.substring(0, k - x);
            String s32 = s2.substring(k - x, k);
            if(MemorySearch(i, j, x, dp, s11, s21) &&
                    MemorySearch(i + x, j + x, k - x, dp, s12, s22)) {
                dp[i][j][k] = 1;
                return true;
            }
            if(MemorySearch(i, j + k - x, x, dp, s11, s32) &&
                    MemorySearch(i + x, j, k - x, dp, s12, s31)) {
                dp[i][j][k] = 1;
                return true;
            }
        }
        dp[i][j][k] = -1;
        return false;
    }
}
