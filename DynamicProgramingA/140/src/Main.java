import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static List<List<Integer>> pathList = new ArrayList<List<Integer>>();

    public static class MultiTreeNode {
        int id;
        List<MultiTreeNode> childList;

        public MultiTreeNode(int id) {
            this.id = id;
            initChildList();
        }

        public void initChildList() {
            if (childList == null)
                childList = new ArrayList<MultiTreeNode>();
        }


        public MultiTreeNode getNodeById(int id) {
            if(this.id == id) {
                return this;
            }
            if(this.childList == null || this.childList.isEmpty()) {
                return null;
            } else {
                for(MultiTreeNode node : this.childList) {
                    MultiTreeNode node1 = node.getNodeById(id);
                    if(node1 != null) {
                        return node1;
                    }
                }
                return null;
            }
        }

        public void dfsTraverse(List<Integer> list) {
            list.add(this.id);
            List<MultiTreeNode> childList = this.childList;
            if(childList == null || childList.isEmpty()) {
                pathList.add(list);
            } else {
                for(MultiTreeNode node : this.childList) {
                    node.dfsTraverse(new ArrayList<Integer>(list));
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "catsanddog";
        Set<String> wordDict = new HashSet<String>(){{add("cat");add("sand");add("dog");add("cats");add("and");}};
        List<String> list = wordBreak(str, wordDict);
//        for(List<Integer> list1 : pathList) {
//            for(int i : list1) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
        for(String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        MultiTreeNode root = new MultiTreeNode(0);
        for(int i = 1; i <= len; i++ ) {
            dp[i] = false;
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    MultiTreeNode parent = root.getNodeById(j);
                    MultiTreeNode child;
                    if (root.getNodeById(i) == null) {
                        child = new MultiTreeNode(i);
                    } else {
                        child = root.getNodeById(i);
                    }
                    parent.childList.add(child);
                }
            }
        }
        root.dfsTraverse(new ArrayList<Integer>());
        List<String> strList = new ArrayList<String>();
        for(List<Integer> list : pathList) {
            int left = 0;
            String str = "";
            boolean flag = true;
            for(int i : list) {
                if(i != 0) {
                    if (flag) {
                        str += s.substring(left, i);
                        flag = false;
                    } else {
                        str += " "+s.substring(left, i);
                    }
                    left = i;
                }
            }
            if (!str.equals("") && left == s.length()) {
                strList.add(str);
            }
        }
        return strList;
    }
}
