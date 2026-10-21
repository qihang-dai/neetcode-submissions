class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean res = dfs(board, i, j, word, 0);
                    if(res) return res;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int x, int y, String word, int start){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(start)) {
            return false;
        }
        if(start == word.length() - 1){
            return true;
        }
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        char original = board[x][y];
        board[x][y] = '#'; // 标记已使用，题目中只包含英文字母

        for(int[] d : dir){
            boolean res = dfs(board, x + d[0], y + d[1], word, start + 1);
            if(res) return res;
        }
        board[x][y] = original;

        return false;
    }
}
