package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String str = "abcdd";
        printLists(partition(str));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if(s == null || s.isEmpty()) {
            return rst;
        }
        int n = s.length();
        List<List<Boolean>> flagList = new ArrayList<>();
        List<Boolean> path = new ArrayList<>();
        generateFlag(flagList, path, true, n, 0, s);
        helper(rst, flagList, s);
        return rst;
    }

    public static void helper(List<List<String>> rst, List<List<Boolean>> flagList, String s) {
        for(List<Boolean> flag : flagList) {
            List<String> list = new ArrayList<>();
            putList(flag, s, list);
            rst.add(new ArrayList<>(list));
        }
    }

    public static void generateFlag(List<List<Boolean>> flagList, List<Boolean> path, Boolean flag, int n, int lastIndex, String str) {
        if(path.size() == n) {
            if (flag) {
                flagList.add(new ArrayList<Boolean>(path));
            }
            return;
        }
        path.add(flag);
        if(!isPalindrome(str.substring(lastIndex, path.size()))) {
            generateFlag(flagList, path, false, n, lastIndex, str);
        } else {
            generateFlag(flagList, path, false, n, lastIndex, str);
            generateFlag(flagList, path, true, n, path.size(), str);
        }
        path.remove(path.size() - 1);
    }

    public static void putList(List<Boolean> path, String s, List<String> list) {
        int lastIndex = 0;
        for(int i = 1; i < s.length(); i++) {
            if(path.get(i)) {
                list.add(s.substring(lastIndex, i));
                lastIndex = i;
            }
        }
        list.add(s.substring(lastIndex, s.length()));
    }

    public static boolean isPalindrome(String str) {
        if(str.isEmpty()) {
            return true;
        }
        for(int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void printLists(List<List<String>> rst) {
        for(List<String> list : rst) {
            for(String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static void printList(List<String> rst) {
        for(String str : rst) {
            System.out.print(str + ",");
        }
        System.out.println();
    }

    //TODO jiuzhang solution:
    public ArrayList<ArrayList<String>> partition1(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return result;
        }

        ArrayList<String> path = new ArrayList<String>();
        helper(s, path, 0, result);

        return result;
    }

    private boolean isPalindrome1(String s) {
        int beg = 0;
        int end = s.length() - 1;
        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            }

            beg++;
            end--;
        }

        return true;
    }

    private void helper(String s, ArrayList<String> path, int pos,
                        ArrayList<ArrayList<String>> result) {
        if (pos == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome1(prefix)) {
                continue;
            }

            path.add(prefix);
            helper(s, path, i, result);
            path.remove(path.size() - 1);
        }
    }
}
