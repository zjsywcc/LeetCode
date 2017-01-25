import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        int len = nums.length;
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++) {
            if(indexMap.get(nums[i]) == null) {
                indexMap.put(nums[i], i);
            } else {
                if((i - indexMap.get(nums[i])) <= k) {
                    return true;
                } else {
                    indexMap.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
