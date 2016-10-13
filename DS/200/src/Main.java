public class Main {

    public static void main(String[] args) {
        char[][] island = new char[][]{{'1','1','1','1','0'},
                                       {'1','1','0','1','0'},
                                       {'1','1','0','0','0'},
                                       {'0','0','0','0','0'}};
        char[][] island1 = new char[][]{{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};

        char[][] island2 = new char[][]{{'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};

        char[][] island3 = new char[][]{{'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}};

        char[][] island4 = new char[][]{{'1','0','1','1','0','1','1'}};
        System.out.println(numIslands(island));
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
            return compressedFind(x);
        }

        // Find Method with Path Compression
        public int compressedFind(int x) {
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

    static class IslandUnionFind extends UnionFind {
        public int count;

        public void initIslands(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            this.parent = new int[m * n];
            this.size = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    } else {
                        parent[i * n + j] = -1;
                    }
                    this.size[i * n + j] = 1;
                }
            }
        }

        public void updateCount(int k) {
            count = count + k;
        }

        public int getCount() {
            return count;
        }
    }

    public static boolean inGrid(int i, int j, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return i >=0 && j >= 0 && i < row && j < col;
    }


    public static int numIslands1(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        IslandUnionFind uf = new IslandUnionFind();
        uf.initIslands(grid);
        int row = grid.length;
        int col = grid[0].length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(inGrid(i, j, grid) && grid[i][j] == '1') {
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(inGrid(nx, ny, grid) && grid[nx][ny] == '1') {
                            int cparent = uf.find(i * col + j);
                            int nparent = uf.find(nx * col + ny);
                            if (cparent != nparent) {
                                uf.union(cparent, nparent);
                                uf.updateCount(-1);
                            }
                        }
                    }
                }
            }
        }
        return uf.getCount();
    }

    //dfs version
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if(!inGrid(i, j, grid) || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
