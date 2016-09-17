public class Main {

    public static void main(String[] args) {
        int[] nums1 = new int[4];
        nums1[0] = 1;
        nums1[1] = 3;
        int[] nums2 = new int[] {2,4};
        merge(nums1, 2, nums2, 2);
        for(int i : nums1)
            System.out.println(i);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_bak = new int[100000];
        System.arraycopy(nums1, 0, nums1_bak, 0, m);
        int p1 = 0, p2 = 0, index = 0;
        while(p1 < m && p2 < n) {
            if(nums1_bak[p1] < nums2[p2]) {
                nums1[index++] = nums1_bak[p1];
                p1++;
            } else {
                nums1[index++] = nums2[p2];
                p2++;
            }
        }
        while(p1 < m) {
            nums1[index++] = nums1_bak[p1];
            p1++;
        }
        while(p2 < n) {
            nums1[index++] = nums2[p2];
            p2++;
        }
    }
}
