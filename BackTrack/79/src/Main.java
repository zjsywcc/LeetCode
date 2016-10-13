public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static boolean exist(char[][] board, String word) {
        if(board == null) {
            return false;
        }
        if(word == null || word.length() == 0) {
            return false;
        }
        int row = board.length;
        int col;
        if(row == 0) {
            return false;
        } else {
            col = board[0].length;
        }
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(searchHelper(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchHelper(char[][] board, String word, boolean visited[][], int i, int j, int wi) {
        //out of index
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return false;
        }

        if(!visited[i][j] && board[i][j] == word.charAt(wi)) {
            if(wi == word.length() - 1)
                return true;
            visited[i][j] = true;
            boolean down = searchHelper(board, word, visited, i + 1, j, wi + 1);
            boolean right = searchHelper(board, word, visited, i, j + 1, wi + 1);
            boolean up = searchHelper(board, word, visited, i - 1, j, wi + 1);
            boolean left = searchHelper(board, word, visited, i, j - 1, wi + 1);
            visited[i][j] = up || down || left || right;
            return up || down || left || right;
        }
        return false;
    }
}
