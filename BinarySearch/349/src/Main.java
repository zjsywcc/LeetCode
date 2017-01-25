import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        printList(intersection(nums1, nums2));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> rstSet = new HashSet<Integer>();
        for(int i : nums2) {
            if(binarySearch(nums1, i) != -1) {
                rstSet.add(i);
            }
        }
        int[] rst = new int[rstSet.size()];
        List<Integer> list = new ArrayList<Integer>(rstSet);
        for(int i = 0; i < list.size(); i++) {
            rst[i] = list.get(i);
        }
        return rst;
    }

    public static int binarySearch(int[] A, int target) {
        if(A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(A[mid] == target) {
                end = mid;
            } else if(A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(A[start] == target) {
            return start;
        }
        if(A[end] == target) {
            return end;
        }
        return -1;
    }

    public static void printList(int[] list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
