import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        int[][] matrix1 = new int[][]{{1, 2},{3, 4}};
        int[][] matrix2 = new int[][]{{1}};
        printArray(spiralOrder(matrix2));
    }

    // the square matrix
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return null;
        }
        int len = matrix.length;
        List<Integer> rst = new ArrayList<Integer>();
        for(int i = 0; i < len; i++) {
            int row = i;
            int col = i;
            while(row == i && col < len - i) {
                rst.add(matrix[row][col]);
                col++;
            }
            col--;
            row++;
            while(col == len - i - 1 && row < len - i) {
                rst.add(matrix[row][col]);
                row++;
            }
            row--;
            col--;
            while(row == len - i - 1 && col >= i) {
                rst.add(matrix[row][col]);
                col--;
            }
            col++;
            row--;
            while(col == i && row >= i + 1) {
                rst.add(matrix[row][col]);
                row--;
            }
        }
        return rst;
    }

    // don't want to waste time steal from jiuzhang solution
    static class Direction {
        public static int DOWN = 0;
        public static int RIGHT = 1;
        public static int LEFT = 2;
        public static int UP = 3;

        private static int[] dx = new int[]{1, 0, 0, -1};
        private static int[] dy = new int[]{0, 1, -1, 0};

        public static int turnRight(int direction) {
            if (direction == DOWN) {
                return LEFT;
            } else if (direction == RIGHT) {
                return DOWN;
            } else if (direction == LEFT) {
                return UP;
            } else if (direction == UP) {
                return RIGHT;
            }
            return -1;
        }

        public static int[] move(int[] cursor, int direction) {
            int[] nextCursor = new int[2];
            nextCursor[0] = cursor[0] + dx[direction];
            nextCursor[1] = cursor[1] + dy[direction];
            return nextCursor;
        }
    }


    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();

        // check corner case
        if (matrix == null || matrix.length == 0) {
            return order;
        }
        int n = matrix.length;

        if (matrix[0] == null || matrix[0].length == 0) {
            return order;
        }
        int m = matrix[0].length;

        int direction = Direction.RIGHT;
        int[] cursor = new int[]{0, 0};

        for (int i = 0; i < n * m; i++) {
            order.add(matrix[cursor[0]][cursor[1]]);
            // mark the visited position as Integer.MIN_VALUE
            matrix[cursor[0]][cursor[1]] = Integer.MIN_VALUE;
            int[] nextCursor = Direction.move(cursor, direction);
            // if outside of matrix or marked before, turn right
            if (nextCursor[0] < 0 || nextCursor[0] >= n ||
                    nextCursor[1] < 0 || nextCursor[1] >= m ||
                    matrix[nextCursor[0]][nextCursor[1]] == Integer.MIN_VALUE) {
                direction = Direction.turnRight(direction);
                nextCursor = Direction.move(cursor, direction);
            }
            cursor = nextCursor;
        }

        return order;
    }


    public static void printArray(List<Integer> list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
