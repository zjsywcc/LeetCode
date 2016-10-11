public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("ab"));
//        System.out.println(trie.startsWith("eat"));
    }

        class TrieNode {


            TrieNode[] child;
            String word;
            public TrieNode() {
                child = new TrieNode[26];
                word = "";
            }
        }


        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            char[] wordChar = word.toCharArray();
            TrieNode node = root;
            for(char c : wordChar) {
                if(node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TrieNode();
                }
                node = node.child[c - 'a'];
            }
            node.word = word;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            char[] wordChar = word.toCharArray();
            TrieNode node = root;
            for(char c : wordChar) {
                if(node.child[c - 'a'] == null) {
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return node.word.equals(word);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            char[] wordChar = prefix.toCharArray();
            TrieNode node = root;
            for(char c : wordChar) {
                if (node != null) {
                    if(node.child[c - 'a'] == null) {
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


}
