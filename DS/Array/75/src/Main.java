public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, 2, 0, 1, 0};
        sortColors(nums);
        printList(nums);
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int index = 0;
        while(index <= right) {
            if(nums[index] == 0) {
                swap(nums, index++, left++);
            } else if(nums[index] == 2) {
                swap(nums, index, right--);
            } else {
                index++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        System.out.printf("swap %d and %d", i, j);
    }

    public static void printList(int[] nums) {
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
}
