package com.company;

public class WordDictionary {

    public static void main(String[] args) {
//        addWord("bad");
//        addWord("dad");
//        addWord("mad");
//        System.out.println(search("pad"));
//        System.out.println(search("bad"));
//        System.out.println(search(".ad"));
//        System.out.println(search("b.."));
        addWord("bat");
//        System.out.println("." + search("."));
//        System.out.println("b." + search("b."));
        addWord("a");
        addWord("ab");
        System.out.println("a" + search("a"));
        System.out.println("ab" + search("ab"));
        System.out.println("b." + search("b."));
        System.out.println("b.." + search("b.."));
//        System.out.println("." + search("."));
//        System.out.println("aa" + search("aa"));
//        System.out.println("a" + search("a"));
//        System.out.println(".a" + search(".a"));
//        System.out.println("a." + search("a."));
    }

    static class TrieNode {

        TrieNode[] suffix;
        String word;
        boolean isWord;
//        boolean isLeaf;

        TrieNode() {
            this.suffix = new TrieNode[26];
            this.word = "";
            this.isWord = false;
//            this.isLeaf = true;
        }
    }

    static class Trie {
        TrieNode root;
//        int maxLen;
        Trie() {
            this.root = new TrieNode();
//            this.maxLen = 0;
        }

        private void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode crt = root;
            for(char c : chars) {
                if(crt.suffix[c - 'a'] == null) {
                    crt.suffix[c - 'a'] = new TrieNode();
//                    this.maxLen++;
//                    crt.isLeaf = false;
                }
                crt = crt.suffix[c - 'a'];
            }
            crt.word = word;
            crt.isWord = true;
        }
    }

    static Trie trie = new Trie();
    // Adds a word into the data structure.
    public static void addWord(String word) {
        trie.insert(word);
    }

//    Returns if the word is in the data structure. A word could
//    contain the dot character '.' to represent any one letter.
    public static boolean search(String word) {
//        if(trie.maxLen < word.length()) {
//            return false;
//        }
        return dfs(trie.root, word);
    }

    public static boolean dfs(TrieNode crt, String word) {
        if(crt == null) {
            return false;
        } else if(word.isEmpty()) {
            if(crt.isWord) {
                return true;
            } else {
                return false;
            }
        } else {
            if(word.charAt(0) == '.') {
                boolean flag = false;
                for(int i = 0; i < 26; i++) {
                    flag = flag || dfs(crt.suffix[i], word.substring(1, word.length()));
                }
                return flag;
            } else {
                if(crt.suffix[word.charAt(0) - 'a'] == null) {
                    return false;
                } else {
                    return dfs(crt.suffix[word.charAt(0) - 'a'], word.substring(1, word.length()));
                }
            }
        }
    }
}
