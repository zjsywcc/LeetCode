public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4};
        int[] nums1 = new int[]{5, 25, 75};
//        printArray(twoSum(nums, 6));
        printArray(twoSum1(nums1, 100));
    }

    // Time: O(nlogn)
    public static int[] twoSum(int[] numbers, int target) {
        int result[] = {0,0};
        for(int i = 0;i < numbers.length;i++) {
            int rst = find(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if(rst != -1) {
                result[0] = i + 1;
                result[1] = rst + 1;
                break;
            }
        }
        return result;
    }

    public static int find(int[] numbers, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int left = start;
        int right = end;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(numbers[mid] == target) {
                return mid;
            } else if(numbers[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if(numbers[right] == target) {
            return right;
        }
        if(numbers[left] == target) {
            return left;
        }
        return -1;
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int l = numbers[left];
            int r = numbers[right];
            if(l + r < target) {
                left++;
            } else if(l + r > target){
                right--;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }



    public static void printArray(int[] result) {
        System.out.printf("[%d, %d]", result[0], result[1]);
    }
}
