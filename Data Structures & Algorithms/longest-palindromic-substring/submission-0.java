class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        int bestStart =0;
        int bestEnd = 0;
        for(int i = n -1; i >= 0; i--){
            for(int j = i; j < n; j++){
                dp[i][j] = ((j - i <= 2) || dp[i+1][j-1]) && s.charAt(i) == s.charAt(j);
                if(dp[i][j] && j - i > bestEnd - bestStart){
                    bestStart = i;
                    bestEnd = j ;
                }
            }
        }
        return s.substring(bestStart, bestEnd + 1);
    }
}
