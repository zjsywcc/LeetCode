import java.util.*;

public class Main {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        List<List<String>> rst = findLadders(beginWord, endWord, wordList);
        printLists(rst);
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> rst = new ArrayList<List<String>>();
        HashMap<String, Integer> dstMap = new HashMap<String, Integer>();
        List<String> path = new ArrayList<String>();
        Queue<String> fromLast = new LinkedList<String>();
        fromLast.offer(endWord);
        if(wordList.contains(endWord)) {
            wordList.remove(endWord);
        }
        wordList.add(beginWord);
        Set<String> wordListBak = new HashSet<String>(wordList);
        int dst = 0;
        boolean hasPath = false;
        while(!fromLast.isEmpty()) {
            dst++;
            int size = fromLast.size();
            for(int i = 0; i < size; i++) {
                String head = fromLast.poll();
                if(dst == 1 && getNextWords(head, wordList).size() == 0) {
                    return rst;
                }
                for(String prevWord : getNextWords(head, wordList)) {
                    if(prevWord.equals(beginWord)) {
                        hasPath = true;
                    }
                    fromLast.offer(prevWord);
                    dstMap.put(prevWord, dst);
                    wordList.remove(prevWord);
                }
            }
        }
        if(!hasPath) {
            return rst;
        }
        dfs(rst, path, beginWord, wordListBak, dstMap);
        for(List<String> list : rst) {
            list.add(endWord);
        }
        return rst;
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

    private static void dfs(List<List<String>> rst, List<String> path, String crt, Set<String> wordList, HashMap<String, Integer> dstMap) {
        if(dstMap.get(crt) == 1) {
            path.add(crt);
            rst.add(new ArrayList<String>(path));
            path.remove(path.size() - 1);
            return;
        }
        for(String nextWord : getNextWords(crt, wordList)) {
            if(dstMap.get(nextWord) >= dstMap.get(crt)) {
                continue;
            }
            path.add(crt);
            dfs(rst, path, nextWord, wordList, dstMap);
            path.remove(path.size() - 1);
        }
    }

    private static void printLists(List<List<String>> rst) {
        for(List<String> list : rst) {
            for(String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
