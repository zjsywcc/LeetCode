public class Main {

    public static void main(String[] args) {
        String[] strs = new String[]{"abc", "ab", "ab"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        String commonStr = "";
        int index = 0;
        boolean breakLoop = false;
        while (true) {
            char c = ' ';
            for(int i = 0; i < strs.length; i++) {
                if(index >= strs[i].length()) {
                    breakLoop = true;
                    break;
                }
                if(i == 0) {
                    c = strs[i].charAt(index);
                } else {
                    if(c != strs[i].charAt(index)) {
                        breakLoop = true;
                        break;
                    }
                }
            }
            if(breakLoop) {
                break;
            }
            commonStr += c;
            index++;
        }
        return commonStr;
    }
}
