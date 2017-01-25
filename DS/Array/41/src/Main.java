public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        int[] nums1 = new int[]{3,4,-1,1};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{1000, -1};
        int[] nums4 = new int[]{};
        int[] nums5 = new int[]{1, 1};
        int[] nums6 = new int []{3,-1,23,7,21,12,8,9,18,21,-1,16,1,13,-3,22,23,13,7,14,3,6,4,-3};
        System.out.println(firstMissingPositive1(nums));
        System.out.println(firstMissingPositive1(nums1));
        System.out.println(firstMissingPositive1(nums2));
        System.out.println(firstMissingPositive1(nums3));
        System.out.println(firstMissingPositive1(nums4));
        System.out.println(firstMissingPositive1(nums5));
        System.out.println(firstMissingPositive1(nums6));
    }

    // Time: O(n) Space:???
    public static int firstMissingPositive(int[] nums) {
        int max = 0;
        for(int i : nums) {
            if(i > max) {
                max = i;
            }
        }
        int[] bucket = new int[max + 2];
        for(int i : nums) {
            if(i > 0) {
                bucket[i] = 1;
            }
        }
        int firstPositive = 0;
        for(int i = 1; i <= max + 1; i++) {
            if(bucket[i] == 0) {
                firstPositive = i;
                break;
            }
        }
        return firstPositive;
    }


    // Time: O(n) Space:O(1)
    public static int firstMissingPositive1(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > len || nums[i] < 1) {
                nums[i] = 0;
            } else if(nums[i] != i + 1) {
                int left = i;
                int right = nums[left] - 1;
                while(right >= 0 && nums[left] != left + 1) {
                    if(nums[left] == nums[right]) {
                        break;
                    }
                    swap(nums, left, right);
                    right = nums[left] - 1;
                }
            }
        }
        int firstPositive = len + 1;
        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1) {
                firstPositive = i + 1;
                break;
            }
        }
        return firstPositive;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
