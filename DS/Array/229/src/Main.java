import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2};
        int[] nums1 = new int[]{1,2,2,3,2,1,1,3};
        printList(majorityElement(nums1));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return rst;
        }
        int len = nums.length;
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0, candidate2 = 0;
        int index = 0;
        for(int i : nums) {
            if(candidate1 == i) {
                count1++;
            } else if(candidate2 == i) {
                count2++;
            } else if(count1 == 0) {
                candidate1 = i;
                count1++;
            } else if(count2 == 0) {
                candidate2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
//            System.out.printf("index: %d candidate1 %d candidate2 %d\n", index++, candidate1, candidate2);
        }
        count1 = 0;
        count2 = 0;
        for(int i : nums) {
            if(i == candidate1) {
                count1++;
            } else if(i == candidate2) {
                count2++;
            }
        }
        if(count1 > len / 3) {
            rst.add(candidate1);
        }
        if(count2 > len / 3) {
            rst.add(candidate2);
        }
        return rst;
    }

    public static void printList(List<Integer> list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
