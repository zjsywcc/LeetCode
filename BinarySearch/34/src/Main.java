public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] a = searchRange(nums, 7);
        System.out.println("lb: "+a[0]+" ub: "+a[1]);
    }

    /*
    * nums[index] >= target, min(index)
    */
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb + 1;
    }

    /*
    * nums[index] <= target, max(index)
    */
    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub - 1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        if(ub == -1 || lb == nums.length) {
            return new int[]{-1, -1};
        } else {
            if(nums[lb] == target && nums[ub] == target) {
                int[] a = {lb, ub};
                return a;
            } else if (nums[lb] != target && nums[ub] != target) {
                int[] a = {-1, -1};
                return a;
            } else if(nums[lb] != target) {
                int[] a = {ub, ub};
                return a;
            } else {
                int[] a = {lb, lb};
                return a;
            }
        }
    }
}
