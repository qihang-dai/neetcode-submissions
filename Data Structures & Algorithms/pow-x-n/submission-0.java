class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        if(n == 1) return x;
        return myPow(x, n - 1) * x;
    }
}
