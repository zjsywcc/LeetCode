import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> result = permute(new int[]{1, 2, 3});
        printLists(result);
    }

    static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbours;

        UndirectedGraphNode(int label) {
            this.label = label;
            this.neighbours = new ArrayList<UndirectedGraphNode>();
        }
    }

    //TODO learn from the ninechap solution
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode node;
        ArrayList<UndirectedGraphNode> nodeList = new ArrayList<UndirectedGraphNode>();
        for(int num : nums) {
            node = map.get(num);
            if (node == null) {
                node = new UndirectedGraphNode(num);
                map.put(num, node);
            }
            nodeList.add(node);
            ArrayList<UndirectedGraphNode> neighbours = new ArrayList<UndirectedGraphNode>();
            for(int n : nums) {
                if(n != num) {
                    UndirectedGraphNode next = map.get(n);
                    if(next == null) {
                        next = new UndirectedGraphNode(n);
                        map.put(n, next);
                        neighbours.add(next);
                    } else {
                        neighbours.add(next);
                    }
                }
            }
            node.neighbours = neighbours;
        }
//        List<String> res = new ArrayList<String>();
        for(UndirectedGraphNode root : nodeList) {
            HashMap<UndirectedGraphNode, Boolean> flag = new HashMap<UndirectedGraphNode, Boolean>();
//            System.out.println(String.format("root: %s", root.label));
//            String path = "";
            List<Integer> path = new ArrayList<Integer>();
            dfs(root, result, path, flag, len);
        }
//        printListStr(res);
        return result;
    }

    public static void dfs(UndirectedGraphNode root, List<List<Integer>> result, List<Integer> path, HashMap<UndirectedGraphNode, Boolean> flag, int len) {
        if(root == null || (flag.get(root) != null && flag.get(root)) || len < 0) {
            return;
        }
        path = new ArrayList<Integer>(path);
        path.add(root.label);
        len--;
        if(len == 0) {
            result.add(path);
        }
        flag.put(root, true);
        for(UndirectedGraphNode next : root.neighbours) {
            if (flag.get(next) == null || !flag.get(next)) {
//                System.out.println(String.format("next: %s", next.label));
                dfs(next, result, path, flag, len);
                flag.put(next, false);
            }
        }
//        result.add(path); //if add here kind of subset solution
    }

    public static void printLists(List<List<Integer>> result) {
        for(List<Integer> list : result) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // The ninechap solution
    public List<List<Integer>> permute1(int[] nums) {
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null) {
            return rst;
        }

        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst, list, nums);
        return rst;
    }

    public void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(rst, list, nums);
            list.remove(list.size() - 1);
        }

    }

}
