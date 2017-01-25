import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        printLists(combinationSum3(3, 7));
        printLists(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> path = new ArrayList<Integer>();
        helper(result, path, nums, 0, n, -1, k);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> path, int[] nums, int sum, int target, int lastAdded, int k) {
        if(sum == target && path.size() == k) {
            List<Integer> sorted = new ArrayList<Integer>(path);
            Collections.sort(sorted);
            if(!result.contains(sorted)) {
                result.add(sorted);
            }
        }
        if(sum > target || path.size() > k) {
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(lastAdded >= i) {
                continue;
            }
            path.add(nums[i]);
            helper(result, path, nums, sum + nums[i], target, i, k);
            path.remove(path.size() - 1);
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
