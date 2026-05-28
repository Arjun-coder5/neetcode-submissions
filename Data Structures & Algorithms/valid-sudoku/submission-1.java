class Solution {

    public boolean isValidSudoku(char[][] board) {

        for(int r = 0; r < 9; r++) {

            for(int c = 0; c < 9; c++) {

                char num = board[r][c];

                // Skip empty cells
                if(num == '.') {
                    continue;
                }

                // Temporarily remove current cell
                board[r][c] = '.';

                // Check row
                if(checkRow(board, r, num)) {
                    return false;
                }

                // Check column
                if(checkCol(board, c, num)) {
                    return false;
                }

                // Check box
                if(checkBox(board, r, c, num)) {
                    return false;
                }

                // Put back
                board[r][c] = num;
            }
        }

        return true;
    }

    // Check row
    public boolean checkRow(char[][] board, int r, char num) {

        for(int c = 0; c < 9; c++) {

            if(board[r][c] == num) {
                return true;
            }
        }

        return false;
    }

    // Check column
    public boolean checkCol(char[][] board, int c, char num) {

        for(int r = 0; r < 9; r++) {

            if(board[r][c] == num) {
                return true;
            }
        }

        return false;
    }

    // Check 3x3 box
    public boolean checkBox(char[][] board,
                            int r,
                            int c,
                            char num) {

        int startRow = (r / 3) * 3;
        int startCol = (c / 3) * 3;

        for(int i = startRow; i < startRow + 3; i++) {

            for(int j = startCol; j < startCol + 3; j++) {

                if(board[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }
}