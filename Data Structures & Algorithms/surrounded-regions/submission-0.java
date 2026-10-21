class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' 
                && (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)){
                    dfs(i, j, board);
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(int x, int y, char[][] board){
        if(x < 0 || y < 0 || x >= board.length|| y >= board[0].length || board[x][y] != 'O'){
            return;
        }

        board[x][y] = '#';

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int[] dir : dirs){
            int nx = x + dir[0], ny = y + dir[1];
            dfs(nx, ny, board);
        }
    }
}