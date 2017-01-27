import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String digits = "2";
        printStrings(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return rst;
        }
        char[][] map = new char[][]{{'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        String crt = "";
        helper(rst, crt, map, digits);
        return rst;
    }

    public static void helper(List<String> rst, String crt, char[][] map, String digits) {
        if(crt.length() == digits.length()) {
            rst.add(crt);
            return;
        }
        int index = crt.length();
        for(int i = 0; i < map[digits.charAt(index) - '2'].length; i++) {
            crt += map[digits.charAt(index) - '2'][i];
            helper(rst, crt, map, digits);
            crt = crt.substring(0, crt.length() - 1);
        }
    }

    public static void printStrings(List<String> rst) {
        for(String s : rst) {
            System.out.println(s);
        }
    }
}
