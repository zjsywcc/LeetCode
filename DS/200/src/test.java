/**
 * Created by wcc on 2016/10/13.
 */


public class test {
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

        public void initIslands(boolean grid[][]) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            this.parent = new int[m * n];
            this.size = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == true) {
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

    public static void main(String[] args) {
        boolean[][] island = new boolean[][]{{true, false,true,true,false,true,true}};
        System.out.println(numIslands(island));
    }

    public static boolean insideGrid(int x, int y, int m, int n) {
        return (x >= 0 && y >= 0 && x < m && y < n);
    }
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public static int numIslands(boolean[][] grid) {
        // Check Input
        if(grid==null || grid.length==0 || grid[0].length==0) {
            return 0;
        }

        IslandUnionFind uf = new IslandUnionFind();
        uf.initIslands(grid);

        int m = grid.length;
        int n = grid[0].length;

        // Helper Direction Array
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        // Row and Column Traversal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (insideGrid(i, j, m, n) && grid[i][j]) {

                    // 4 directions for each point
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (insideGrid(nx, ny, m, n) && grid[nx][ny]) {
                            int cparent = uf.find(i * n + j);
                            int nparent = uf.find(nx * n + ny);
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
}
