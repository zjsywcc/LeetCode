import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Set<Character> set = new HashSet<Character>();
//        set.add('a');
//        set.add('b');
//        for(char c : set) {
//            System.out.println(c);
//        }
        printList(findAnagrams("cbaebabacd", "abc"));
        printList(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<Integer>();
        if(s == null || p == null || p.length() > s.length()) {
            return rst;
        }
        int[] pIndex = new int[26];
        for(char c : p.toCharArray()) {
            pIndex[c - 'a']++;
        }
        int pLen =  p.length();
        int tempLen = pLen;
        int sLen = s.length();
        int delete = -1;
        int add = pLen - 1;
        for(int i = 0; i < tempLen; i++) {
            if(pIndex[s.toCharArray()[i] - 'a']-- > 0) {
                pLen--;
            }
        }
        for(; add < sLen; add++, delete++) {
            if(delete != -1) {
                if(pIndex[s.toCharArray()[add] - 'a']-- > 0) {
                    pLen--;
                }
                if(pIndex[s.toCharArray()[delete] - 'a']++ >= 0) {
                    pLen++;
                }
                if(pLen == 0) {
                    rst.add(delete + 1);
                }
            } else {
                if(pLen == 0) {
                    rst.add(delete + 1);
                }
            }
        }
        return rst;
    }

    public static void printList(List<Integer> rst) {
        for(int i : rst) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printSet(Set<Integer> set) {
        for(int i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
