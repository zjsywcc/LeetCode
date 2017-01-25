import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String str = "leetcode";
        Set<String> wordDict = new HashSet<String>(){{add("lee");add("tco");}};
        System.out.println(wordBreak(str, wordDict));
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++ ) {
            dp[i] = false;
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }


}
