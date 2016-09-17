import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{-1,0,0,0,0,3,3}));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] a = new int[1000000];
        int delta = 1000;
        int temp = nums[0];
        a[temp + delta] = 1;
        List<Integer> index = new ArrayList<>();
        index.add(temp);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == temp) {
                a[temp+delta]++;
            } else {
                temp = nums[i];
                a[temp+delta] = 1;
                index.add(temp);
            }
        }
        int count = 0;
        int start = 0;
        for(int i : index) {
            if(a[i+delta] >= 2) {
                count += 2;
                nums[start++] = i;
                nums[start++] = i;
            } else {
                count += 1;
                nums[start++] = i;
            }
        }
        return count;
    }
}
