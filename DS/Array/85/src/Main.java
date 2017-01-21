import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col;
        if(row > 0) {
            col = matrix[0].length;
        } else {
            return 0;
        }
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : dp[i - 1][j] + 1;
                }
            }
        }
        int maxRec = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++) {
            int crt = largestRectangleArea(dp[i]);
            if(crt > maxRec) {
                maxRec = crt;
            }
        }
        return maxRec;
    }

    public static int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] nums = new int[len + 2];
        for(int i = 0; i < len + 2; i++) {
            if(i == 0 || i == len + 1) {
                nums[i] = 0;
            } else {
                nums[i] = height[i - 1];
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for(int i = 1; i < len + 2; i++) {
            int top = stack.lastElement();
            if(nums[i] >= nums[top]) {
                stack.push(i);
            } else {
                int sum;
                while(!stack.isEmpty() && nums[stack.lastElement()] > nums[i]) {
                    int h = stack.pop();
                    int ln = stack.lastElement();
                    int rn = i;
                    sum = (rn - ln - 1) * nums[h];
                    max = Math.max(max, sum);
                }
                stack.push(i);
            }
        }
        return max;
    }
}
