public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, -1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int colStart = 0, rowEnd = matrix.length - 1;
        while(colStart <= matrix[0].length - 1 && rowEnd >= 0) {
            if(matrix[rowEnd][colStart] == target) {
                return true;
            } else if(matrix[rowEnd][colStart] > target) {
                rowEnd -= 1;
            } else {
                colStart += 1;
            }
        }
        return false;
    }
}
