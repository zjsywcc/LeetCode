public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, -3, 2, 5};
        System.out.println(singleNumber(nums)[0] + " " + singleNumber(nums)[1]);
//        singleNumber(nums);
//        System.out.println(-2 ^ 2);
    }

    public static int[] singleNumber(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum ^= i;
        }
        int filter = getLastBit(sum);
        int a = 0;
        int b = 0;
//        System.out.println(filter);
        for(int i : nums) {
            if((filter & i) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
//        System.out.println("a: " + a);
//        System.out.println("b: " + b);
        return new int[]{a, b};
    }

    public static int getLastBit(int num) {
        return num - (num & (num -1));
    }

//    public static boolean xor(int filter, int num) {
//        int f  = (int) Math.pow(2, filter);
//        return ((f ^ num) / f) % 2 == 0;
//    }
}
