public class Main {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(11));
    }

    public static int firstBadVersion(int n) {
        if(n == 0) {
            return -1;
        }
        int start = 1, end = n;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(isBadVersion(start)) {
            return start;
        }
        if(isBadVersion(end)) {
            return end;
        }
        return -1;
    }

    public static boolean isBadVersion(int i) {
        if(i >= 5) {
            return true;
        }
        return false;
    }
}
