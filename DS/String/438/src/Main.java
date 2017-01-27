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
        int len = s.length();
        int pLen = p.length();
        List<Character> list = new ArrayList<Character>();
        List<Character> compareList = new ArrayList<Character>();
        char[] chars = s.toCharArray();
        int crt1 = 0;
        int crt2 = pLen - 1;
        for(int i = 0; i <= crt2; i++) {
            char c = s.charAt(i);
            list.add(c);
        }
        Collections.sort(list);
        for(char c : p.toCharArray()) {
              
                compareList.add(c);

        }
        while(crt2 < len) {
            if(list.size() == pLen) {
                rst.add(crt1);
            }
            char c = s.toCharArray()[crt1];
            int index = list.indexOf(c);
            list.remove(index);
            crt1++;
            crt2++;
            if(crt2 >= len) {
                break;
            }
            if(compareList.contains(chars[crt2])) {
                list.add(chars[crt2]);
            }
        }
        return rst;
    }

    public static void printList(List<Integer> rst) {
        for(int i : rst) {
            System.out.print(i + " ");
        }
    }

    public static void printSet(Set<Integer> set) {
        for(int i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
