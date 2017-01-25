public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 33));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        for(int i = 0; i < matrix.length; i++) {
            if(hasTarget(matrix[i], target)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasTarget(int[] array, int target) {
        if(array == null || array.length == 0) {
            return false;
        }
        int len = array.length;
        int start = 0, end = len - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] == target) {
                return true;
            } else if(array[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(array[start] == target) {
            return true;
        }
        if(array[end] == target) {
            return true;
        }
        return false;
    }
}
