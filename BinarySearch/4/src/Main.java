public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 0) {
            return (findkth(nums1, 0, nums2, 0, len / 2) + findkth(nums1, 0, nums2, 0, len / 2 + 1))/2.0;
        } else {
            return  findkth(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }

    public static int findkth(int[] a, int aStart, int [] b, int bStart, int k) {
        if(aStart >= a.length) {
            return b[bStart + k - 1];
        }
        if(bStart >= b.length) {
            return a[aStart + k -1];
        }
        if(k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }
        int aK = aStart + k / 2 - 1 < a.length ? a[aStart + k / 2 - 1] : Integer.MAX_VALUE;
        int bK = bStart + k / 2 - 1 < b.length ? b[bStart + k / 2 - 1] : Integer.MAX_VALUE;
        if(aK < bK) {
            return findkth(a, aStart + k / 2, b, bStart, k - k / 2);
        } else {
            return findkth(a, aStart, b, bStart + k / 2, k - k / 2);
        }
    }
}
