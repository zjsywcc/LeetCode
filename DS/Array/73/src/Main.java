public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 1}, {0, 2, 2}};
        int[][] matrix1 = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setZeroes(matrix1);
        printMatrix(matrix1);
    }

    // O(m + n) space, is easy in order to use O(1) have to store in the first row and first column
    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(matrix[i][j] == 0) {
                    for(int x = 0; x < r; x++) {
                        if (matrix[x][j] != 0) {
                            matrix[x][j] = Integer.MIN_VALUE >> 1;
                        }
                    }
                    for(int y = 0; y < c; y++) {
                        if (matrix[i][y] != 0) {
                            matrix[i][y] = Integer.MIN_VALUE >> 1;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(matrix[i][j] == Integer.MIN_VALUE >> 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
