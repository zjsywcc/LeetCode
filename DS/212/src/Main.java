import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        char[][] board1 = new char[][]{{'a', 'a'}};
        char[][] board2 = new char[][]{{'a', 'b'},
                                        {'c', 'd'}};
        char[][] board3 = new char[][]{{'a', 'a'}};
        char[][] board4 = new char[][]{{'a', 'b'},
                {'a', 'a'}};
            char[][] board5 = new char[][]{{'a', 'b', 'c'},
                {'a', 'e', 'd'},
                    {'a', 'f', 'g'}};
        String[] words = new String[]{"eat", "oath"};
        String[] words1 = new String[]{"a"};
        String[] words2 = new String[]{"bacd"};
        String[] words3 = new String[]{"aaa"};
        String[] words4 = new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        String[] words5 = new String[]{"abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"};
        List<String> result = findWords(board5, words5);
        if (result != null) {
            for (String str : result) {
                System.out.print(str + " ");
            }
        } else {
            System.out.println("null");
        }
    }

    static class TrieNode {
        TrieNode[] child;
        String word;

        public TrieNode() {
            child = new TrieNode[26];
            word = "";
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            char[] wordChar = word.toCharArray();
            TrieNode node = root;
            for (char c : wordChar) {
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TrieNode();
                }
                node = node.child[c - 'a'];
            }
            node.word = word;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            char[] wordChar = prefix.toCharArray();
            TrieNode node = root;
            for (char c : wordChar) {
                if (node != null) {
                    if (node.child[c - 'a'] == null) {
                        return false;
                    } else {
                        node = node.child[c - 'a'];
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            char[] wordChar = word.toCharArray();
            TrieNode node = root;
            for (char c : wordChar) {
                if (node.child[c - 'a'] == null) {
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return node.word.equals(word);
        }
    }


    public static List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return results;
        }
        if (words == null || words.length == 0) {
            return results;
        }
        Trie trie = new Trie();
        for (String str : words) {
            if (!str.equals("")) {
                trie.insert(str);
            }
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                searchHelper(board, "", trie, visited, i, j, hashSet);
            }
        }
        results = new ArrayList<String>(hashSet);
        return results;
    }

    public static void searchHelper(char[][] board, String current, Trie trie, boolean visited[][], int i, int j, HashSet<String> hashSet) {
        //out of index
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j]) {
            return;
        }
        current += board[i][j];
        if(!trie.startsWith(current)) {
            return;
        }
        visited[i][j] = true;
        if (trie.search(current)) {
            hashSet.add(current);
        }
        searchHelper(board, current, trie, visited, i + 1, j, hashSet);
        searchHelper(board, current, trie, visited, i, j + 1, hashSet);
        searchHelper(board, current, trie, visited, i - 1, j, hashSet);
        searchHelper(board, current, trie, visited, i, j - 1, hashSet);
        visited[i][j] = false;
    }
}
