public class Main {

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] chars1 = new char[][]{{'1'}};
        char[][] chars2 = new char[][]{{'0','0','0','0'}};
        System.out.println(maximalSquare(chars2));
    }

    //TODO think about the 01矩阵里面找一个，对角线全为1， 其他为0的矩阵 problem
    public static int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c;
        if(r > 0)
            c = matrix[0].length;
        else
            return 0;
        int[][] dp = new int[r][c];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < c; i++) {
            dp[0][i] = matrix[0][i] - 48;
            if(dp[0][i] > max)
                max = dp[0][i];
        }
        for(int j = 0; j < r; j++) {
            dp[j][0] = matrix[j][0] - 48;
            if(dp[j][0] > max)
                max = dp[j][0];
        }
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                if(dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }
}
