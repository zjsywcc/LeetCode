public class Main {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,3,3}));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int temp = nums[0], count = 1, index = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != temp) {
                count++;
                temp = nums[i];
                nums[index++] = nums[i];
            }
        }
        return count;
    }
}
