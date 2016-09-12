public class Main {
    static int num = 6;
    public static void main(String[] args) {
        System.out.println("guess number:" + guessNumber(10));
    }

    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static int guessNumber(int n) {
        if(n < 1) {
            return -1;
        }
        if(n == 1) {
            return 1;
        }
        int start = 1, end = n;
        while(start + 1 < n) {
            int mid = start + (end - start) / 2; //防止两数相加后溢出
            if(guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(guess(start) == 0) {
            return start;
        }
        if(guess(end) == 0) {
            return end;
        }
        return -1;
    }

    public static int guess(int a) {
        if(a > num) {
            return -1;
        } else if(a < num) {
            return 1;
        } else {
            return 0;
        }
    }
}
