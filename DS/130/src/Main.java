import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board1 = new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        char[][] board2 = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        solve(board2);
        printBoard(board2);
    }

    //dfs version copyright : http://blog.csdn.net/ljiabin/article/details/41345055
    public void solve1(char[][] board) {
        int row = board.length;
        if (row < 3) return;
        int col = board[0].length;
        if (col < 3) return;

        // first column and last column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '#';
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = '#';
                dfs(board, i, col - 1);
            }
        }

        // first row and last row
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '#';
                dfs(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                board[row - 1][j] = '#';
                dfs(board, row - 1, j);
            }
        }

        // change 'O' to 'X', restore '#' to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;

        // up
        if (i > 1 && board[i - 1][j] == 'O') {
            board[i - 1][j] = '#';
            dfs(board, i - 1, j);
        }
        // below
        if (i < row - 2 && board[i + 1][j] == 'O') {
            board[i + 1][j] = '#';
            dfs(board, i + 1, j);
        }
        // left
        if (j > 1 && board[i][j - 1] == 'O') {
            board[i][j - 1] = '#';
            dfs(board, i, j - 1);
        }
        // right
        if (j < col - 2 && board[i][j + 1] == 'O') {
            board[i][j + 1] = '#';
            dfs(board, i, j + 1);
        }
    }

    public static void printBoard(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //BFS version
    char[][] board;
    int row;
    int col;
    Queue<Integer> queue = new LinkedList<Integer>();

    public void solve2(char[][] board) {
        this.board = board;
        row = board.length;
        if (row < 3) return;
        col = board[0].length;
        if (col < 3) return;

        // traverse first column and last column
        for (int i = 0; i < row; i++) {
            bfs(i, 0);
            bfs(i, col - 1);
        }

        // traverse first row and last row
        for (int j = 0; j < col; j++) {
            bfs(0, j);
            bfs(row - 1, j);
        }

        // change 'O' to 'X', restore '#' to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(int i, int j) {
        fill(i, j);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / col;
            int y = pos % col;

            fill(x - 1, y);
            fill(x + 1, y);
            fill(x, y - 1);
            fill(x, y + 1);
        }
    }

    public void fill(int i, int j) {
        if (i < 0 || j < 0 || i > row - 1 || j > col - 1) return;
        if (board[i][j] != 'O') return;
        queue.offer(i * col + j);
        board[i][j] = '#';
    }


    //Union find version
    static class UnionFind {
        public int[] parent;
        public int[] size;

        public UnionFind() {}

        public UnionFind(int n) {
            this.parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                this.parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while(x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if(parentX == parentY) {
                return;
            }
            if(this.size[parentX] < this.size[parentY]) {
                this.size[parentY] += this.size[parentX];
                this.parent[parentX] = parentY;
            } else {
                this.size[parentX] += this.size[parentY];
                this.parent[parentY] = parentX;
            }
        }
    }

    static class UnionFindHelper extends UnionFind {
        public void initUnion(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            this.parent = new int[m * n + 1];
            this.size = new int[m * n + 1];

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 'O') {
                        parent[i * n + j] = i * n + j;
                        this.size[i * n + j] = 1;
                    } else {
                        parent[i * n + j] = -1;
                        this.size[i * n + j] = 1;
                    }
                }
            }
            parent[m * n] = m * n;
            size[m * n] = 1;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static boolean isAlign(char[][] board, int x) {
        int row = board.length;
        int col = board[0].length;
        if(x < col || x >= (row - 1) * col || x % col == 0 || (x + 1) % col == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inBoard(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        return i < row && j < col && i >= 0 && j >= 0;
    }

    public static void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        UnionFindHelper union = new UnionFindHelper();
        union.initUnion(board);
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O') {
                    if(isAlign(board, i * col + j)) {
                        union.union(i * col + j, row * col);
                    }
                    else {
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(inBoard(board, nx, ny) && board[nx][ny] == 'O') {
                                int c = i * col + j;
                                int n = nx * col + ny;
                                union.union(c, n);
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < union.parent.length - 1; i++) {
//            System.out.print(union.parent[i] + " ");
//            if((i + 1) % col == 0) {
//                System.out.println();
//            }
            if(union.parent[i] != -1 && !union.connected(union.parent[i], row * col)) {
                board[i / col][i % col] = 'X';
            }
        }
        System.out.println(union.parent[row * col]);
    }
}
