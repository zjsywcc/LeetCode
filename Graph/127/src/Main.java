import java.util.*;

public class Main {

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("cog");
        wordList.add("pot");
        wordList.add("dot");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }


    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        if(wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        if(beginWord.equals(endWord)) {
            return 1;
        }
        int depth = 1;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String head = queue.poll();
                for(String nextWord : getNextWords(head, wordList)) {
                    if(nextWord.equals(endWord)) {
                        return depth;
                    }
                    queue.offer(nextWord);
                    wordList.remove(nextWord);
                }
            }
        }
        return 0;
    }


    private static String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private static ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}
