class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0);

        return ans;
    }

    void solve(char[][] board, int row) {

        if(row == board.length) {
            ans.add(make(board));
            return;
        }

        for(int c = 0; c < board.length; c++) {

            if(safe(board, row, c)) {

                board[row][c] = 'Q';

                solve(board, row + 1);

                board[row][c] = '.';
            }
        }
    }

    boolean safe(char[][] board, int row, int col) {

        int n = board.length;

        // Same column
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        for(int i = row - 1, j = col - 1;
            i >= 0 && j >= 0;
            i--, j--) {

            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Upper-right diagonal
        for(int i = row - 1, j = col + 1;
            i >= 0 && j < n;
            i--, j++) {

            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    List<String> make(char[][] board) {

        List<String> list = new ArrayList<>();

        for(char[] row : board) {
            list.add(new String(row));
        }

        return list;
    }
}