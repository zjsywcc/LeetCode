import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positionList = new int[][]{{0,0}, {0,1}, {1,2}, {2,1}};
        printList(numIslands2(m, n, positionList));
    }

    static class UnionFind {
        public int[] parent;
        public int[] size;

        // Initialize UnionFind
        public UnionFind() {}

        public UnionFind(int n) {
            this.parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                size[i] = 1;
            }
        }

        // Find Method
        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // Union Method with Weight
        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return;
            }

            if (this.size[parentX] < this.size[parentY]) {
                this.size[parentY] += this.size[parentX];
                this.parent[parentX] = parentY;
            } else {
                this.size[parentX] += this.size[parentY];
                this.parent[parentY] = parentX;
            }
        }
    }

    public static boolean inBoard(int i, int j, int m, int n) {
        return i < m && i >= 0 && j < n && j >= 0;
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        if(positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }
        int len = m * n;
        UnionFind union = new UnionFind(len);
        boolean[][] board = new boolean[m][n];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int count = 0;
        for(int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            board[x][y] = true;
            count++;
            int crt = x * n + y;
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int next = nx * n + ny;
                if(inBoard(nx, ny, m, n) && board[nx][ny] && !(union.find(crt) == union.find(next))) {
                    union.union(crt, next);
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void printList(List<Integer> list) {
        for(Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
