
class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char num = board[r][c];

                // Skip empty cells
                if (num == '.') {
                    continue;
                }

                // Create unique keys
                String row = "row" + r + num;
                String col = "col" + c + num;
                String box = "box" + (r / 3) + (c / 3) + num;

                // Check duplicate
                if (set.contains(row) ||
                    set.contains(col) ||
                    set.contains(box)) {

                    return false;
                }

                // Store values
                set.add(row);
                set.add(col);
                set.add(box);
            }
        }

        return true;
    }
}