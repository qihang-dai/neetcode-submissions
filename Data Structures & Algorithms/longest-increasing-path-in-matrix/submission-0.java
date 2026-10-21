class Solution {
    int[][] dp;

    private int dfs(int r, int c, int preval, int[][] matrix) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (r < 0 || c < 0|| c >= matrix[0].length || r >= matrix.length ||
            matrix[r][c] <= preval) {
            return 0;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        int res = 1;
        for (int[]d : directions) {
            res = Math.max(res, 1 + dfs(r + d[0], c + d[1], matrix[r][c], matrix));
        }
        return dp[r][c] = res;

    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int res = 0;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, -1, matrix));
            }
        }
        return res;
    }
}
