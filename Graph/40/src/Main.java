import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] candidates = new int[]{1};
        int target = 1;
        printLists(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(len == 0) {
            return rst;
        }
        List<Integer> solution = new ArrayList<Integer>();
        int sum = 0;
        int lastAdded = -1;
        helper(rst, solution, candidates, target, sum, lastAdded);
        return rst;
    }

    public static void helper(List<List<Integer>> rst, List<Integer> solution, int[] candidates, int target, int sum, int lastAdded) {
        if(sum == target) {
            List<Integer> sorted = new ArrayList<Integer>(solution);
            Collections.sort(sorted);
            if (!rst.contains(sorted)) {
                rst.add(sorted);
            }
        }
        if(sum > target) {
            return;
        }
        for(int i = 0; i < candidates.length; i++) {
            if(lastAdded >= i) {
                continue;
            }
            solution.add(candidates[i]);
            helper(rst, solution, candidates, target, sum + candidates[i], i);
            solution.remove(solution.size() - 1);
        }
    }

    public static void printLists(List<List<Integer>> rst) {
        for(List<Integer> list : rst) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
