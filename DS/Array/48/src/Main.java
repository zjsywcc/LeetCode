public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        rotate(matrix);
        printMatrix(matrix);
    }

    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int temp;
        for(int i = 0; i < row - 1; i++) {
            for(int j = 0; j < col - i - 1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[row - 1 - j][row - 1 - i];
                matrix[row - 1 - j][row - 1 - i] = temp;
            }
        }
        for(int i = 0; i < row / 2; i++) {
            for(int j = 0; j < col; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[row - 1 - i][j];
                matrix[row - 1 - i][j] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(int[] i : matrix) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
