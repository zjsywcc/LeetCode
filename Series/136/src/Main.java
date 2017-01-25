public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int x = 0;
        for(int i : nums) {
            x = x ^ i;
        }
        return x;
    }
}
