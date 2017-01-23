public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(thirdMax1(nums));
    }

    // stupid
    public static int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i : nums) {
            if(i >= first) {
                first = i;
            }
        }
        for(int i : nums) {
            if(i != first && i >= second) {
                second = i;
            }
        }
        for(int i : nums) {
            if(i != first && i != second && i >= third) {
                flag = true;
                third = i;
            }
        }
        if(!flag) {
            return first;
        } else {
            return third;
        }
    }

    public static int thirdMax1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int i : nums) {
            if(i > first) {
                third = second;
                second = first;
                first = i;
            } else if(i > second && i < first) {
                third = second;
                second = i;
            } else if(i >= third && i < second){
                third = i;
            }
//            System.out.printf("first %d second %d third %d\n", first, second, third);
        }
        if(third != Long.MIN_VALUE) {
            return (int)third;
        } else {
            return (int)first;
        }
    }
}
