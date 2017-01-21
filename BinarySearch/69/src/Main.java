public class Main {

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    public static int mySqrt(int x) {
        int len = x / 2 + 1;
        int start = 1;
        int end = len;
        if(x == 1 || x == 0) {
            return x;
        }
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(Math.pow(mid, 2) == x) {
                return mid;
            } else if(Math.pow(mid, 2) > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }
}
