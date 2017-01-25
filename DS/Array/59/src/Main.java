public class Main {

    public static void main(String[] args) {
        printMatrix(generateMatrix(1));
    }

    public static int[][] generateMatrix(int n) {
        if(n == 0) {
            return new int[0][0];
        }
        int len = n;
        int[][] matrix = new int[len][len];
        int num = 1;
        for(int i = 0; i < len; i++) {
            int row = i;
            int col = i;
            while(row == i && col < len - i) {
                matrix[row][col] = num++;
                col++;
            }
            col--;
            row++;
            while(col == len - i - 1 && row < len - i) {
                matrix[row][col] = num++;
                row++;
            }
            row--;
            col--;
            while(row == len - i - 1 && col >= i) {
                matrix[row][col] = num++;
                col--;
            }
            col++;
            row--;
            while(col == i && row >= i + 1) {
                matrix[row][col] = num++;
                row--;
            }
        }
        return matrix;
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
