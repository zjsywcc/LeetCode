public class Main {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] sIndex = new int[26];
        int[] tIndex = new int[26];
        for(char c : s.toCharArray()) {
            sIndex[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            tIndex[c - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(sIndex[i] != tIndex[i]) {
                return false;
            }
        }
        return true;
    }
}
