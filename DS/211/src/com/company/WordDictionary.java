package com.company;

public class WordDictionary {

    public static void main(String[] args) {
	// write your code here
    }

    static class TrieNode {

        TrieNode[] suffix;
        String word;

        TrieNode() {
            this.suffix = new TrieNode[26];
            this.word = "";
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        private void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode crt = root;
            for(char c : chars) {
                if(crt.suffix[c - 'a'] == null) {
                    crt.suffix[c - 'a'] = new TrieNode();
                }
                crt = crt.suffix[c - 'a'];
            }
            crt.word = word;
        }

        private boolean startWith(String prefix) {
            char[] wordChar = prefix.toCharArray();
            TrieNode crt = root;
            for(char c : wordChar) {
                if(crt != null) {
                    if(crt.suffix[c - 'a'] == null) {
                        return false;
                    } else {
                        crt = crt.suffix[c - 'a'];
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        private boolean search(String word) {
            char[] wordChar = word.toCharArray();
            TrieNode node = root;
            for(char c : wordChar) {
                if(node.suffix[c - 'a'] == null) {
                    return false;
                }
                node = node.suffix[c - 'a'];
            }
            return node.word.equals(word);
        }
    }

    Trie trie = new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        char[] wordChar = word.toCharArray();
        for(char c : wordChar) {
            if(c == '.') {

            }
        }
    }

    public static boolean dfs(TrieNode crt, String word) {
        if(crt == null && !word.equals("")) {
            return false;
        }
        if(crt)
    }
}
