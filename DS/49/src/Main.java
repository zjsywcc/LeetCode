import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strings);
        for(List<String> list : lists) {
            for(String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        List<String> index = new ArrayList<String>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(hashMap.get(sortedStr) == null) {
                List<String> list = new ArrayList<String>();
                list.add(str);
                hashMap.put(sortedStr, list);
                index.add(sortedStr);
            } else {
                List<String> list = hashMap.get(sortedStr);
                list.add(str);
            }
        }
        List<List<String>> lists = new ArrayList<List<String>>();
        for(String i : index) {
            List<String> list = new ArrayList<String>();
            List<String> sortedList = hashMap.get(i);
            String[] strings = sortedList.toArray(new String[sortedList.size()]);
            Arrays.sort(strings);
            sortedList = Arrays.asList(strings);
            for(String str : sortedList) {
                list.add(str);
            }
            lists.add(list);
        }
        return lists;
    }
}
