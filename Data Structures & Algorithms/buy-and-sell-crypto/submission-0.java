class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int prevMin = Integer.MAX_VALUE;
        for(int p : prices){
            prevMin = Math.min(prevMin, p);
            res = Math.max(p - prevMin, res);
        }
        return res;
    }
}
