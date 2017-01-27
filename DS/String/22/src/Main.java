import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        System.out.println("123".substring(0, 2));
        printStrings(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        if(n == 0) {
            return rst;
        }
        String str = "";
        char[] pair = new char[]{'(', ')'};
        int leftNum = 0;
        int rightNum = 0;
        helper(rst, str, pair, n, leftNum, rightNum);
        return rst;
    }

    public static void helper(List<String> rst, String str, char[] pair, int n, int leftNum , int rightNum){
        if(rightNum == n && leftNum == n) {
            rst.add(str);
            return;
        }
        for(int i = 1; i >= 0 && leftNum <= n; i--) {
            if(leftNum == rightNum && i == 1) {
                continue;
            }
            str += pair[i];
            if(i == 1) {
                rightNum++;
            } else {
                leftNum++;
            }
            helper(rst, str, pair, n, leftNum, rightNum);
            str = str.substring(0, str.length() - 1);
            if(i == 1) {
                rightNum--;
            } else {
                leftNum--;
            }
        }
    }

    public static void printStrings(List<String> rst) {
        for(String str : rst) {
            System.out.println(str);
        }
    }
}
