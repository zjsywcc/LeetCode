import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,1,-2147483648};
        int[] nums = new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2};
//        int[] nums = new int[]{1};
//        System.out.prlongln(singleNumber(nums));
//        int i = -2147483648;
        System.out.println(singleNumber(nums));
//        System.out.println(i);
    }

    static class Triple {
        boolean flag = false;
        List<Integer> digits;
        int num;

        public Triple(int num) {
            if(num > 0) {
                this.flag = true;
                num = - num;
            }
            this.digits = new ArrayList<Integer>();
            this.num = num;
            while(num != 0) {
                this.digits.add((int)(num % 3));
                num /= 3;
            }
        }

        public Triple(int num, List<Integer> digits, boolean flag) {
            this.digits = digits;
            this.num = num;
            this.flag = flag;
        }

        public Triple plus(Triple t) {
            boolean flag = true;
            if(!sumFlag(this, t)) {
                flag = false;
            }
            List<Integer> rst = new ArrayList<Integer>();
            int shorter = this.digits.size() < t.digits.size() ? this.digits.size() : t.digits.size();
            int i = 0;
            for(; i < shorter; i++) {
                int num = (this.digits.get(i) + t.digits.get(i)) % 3;
                rst.add(num);
            }
            while(i < this.digits.size()) {
                rst.add(this.digits.get(i));
                i++;
            }
            while(i < t.digits.size()) {
                rst.add(t.digits.get(i));
                i++;
            }
            int sum = 0;
            for(int index = 0; index < i; index++) {
                sum += rst.get(index) * Math.pow(3, index);
            }
            return new Triple(sum, rst, flag);
        }
    }

    public static boolean sumFlag(Triple t1, Triple t2) {
        if(!t1.flag && t2.flag && -t1.num > -t2.num) {
            return false;
        } else if(t1.flag && !t2.flag && -t1.num < -t2.num) {
            return false;
        } else if(!t1.flag && !t2.flag) {
            return false;
        } else {
            return true;
        }
    }

    public static int singleNumber(int[] nums) {
        Triple sum = new Triple(0);
        for(int i : nums) {
            sum = sum.plus(new Triple(i));
//            printTriple(sum);
        }
        if(sum.flag && sum.num < 0) {
            return -sum.num;
        }
        return sum.num;
    }

    private static void printTriple(Triple t) {
        System.out.print("num: " + t.num + " digits: ");
        for(int i : t.digits) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // jiuzhang solution
    public int singleNumber1(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }

            result |= (bits[i] << i);
        }
        return result;
    }
}
