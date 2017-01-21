import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        int[] A1 = new int[]{-1, -1};
        int[] B = new int[]{-2, -1};
        int[] B1 = new int[]{-1, 1};
        int[] C = new int[]{-1, 2};
        int[] C1 = new int[]{-1, 1};
        int[] D = new int[]{0, 2};
        int[] D1 = new int[]{1, -1};
        System.out.println(fourSumCount(A1, B1, C1, D1));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        boolean aEmpty = A == null || A.length == 0;
        boolean bEmpty = B == null || B.length == 0;
        boolean cEmpty = C == null || C.length == 0;
        boolean dEmpty = D == null || D.length == 0;
        if(aEmpty || bEmpty || cEmpty || dEmpty) {
            return 0;
        }
        HashMap<Integer, Integer> flag = new HashMap<Integer, Integer>();
        for(int i : A) {
            for(int j : B) {
                if(!flag.containsKey(i + j)) {
                    flag.put(i + j, 1);
                } else {
                    flag.put(i + j, flag.get(i + j) + 1);
                }
            }
        }
        int count = 0;
        for(int i : C) {
            for(int j: D) {
                Integer has = flag.get(-(i + j));
                if(has != null) {
                    count += has;
                }
            }
        }
        return count;
    }

}
