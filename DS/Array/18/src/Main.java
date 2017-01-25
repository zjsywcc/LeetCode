import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0};
        int[] nums1 = new int[]{-3, -1, 0, 2, 4, 5};
        int[] nums2 = new int[]{-3,-2,-1,0,0,1,2,3};
        int[] nums3 = new int[]{1,-5,1,-4,2,1,-3};
        printLists(fourSum(nums3, 1));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) {
            return lists;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int current;
        for (int x = 0; x < len - 1; x++) {
            if (x != 0 && nums[x] == nums[x - 1]) {
                continue;
            }
            for(int i = x + 1; i < len - 1; i++) {
                if(x != i - 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int b = nums[x];
                int a = nums[i];
                int j = i + 1;
                int k = len - 1;
                while(j < k) {
                    current = b + a + nums[j] + nums[k];
                    if (current == target) {
                        List<Integer> solution = new ArrayList<Integer>();
                        solution.add(nums[x]);
                        solution.add(nums[i]);
                        solution.add(nums[j]);
                        solution.add(nums[k]);
                        lists.add(solution);
                        j++;
                        k--;
                        while(j < len && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while(k >= 0 &&  nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if(current < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return lists;
    }

    public static void printLists(List<List<Integer>> lists) {
        for(List<Integer> list : lists) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
