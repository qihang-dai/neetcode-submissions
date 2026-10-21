class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 1;
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        return pow(x, n);
    }
    private double pow(double x, int n){
        if(n == 0) return 1;
        return n % 2 == 1? pow(x, n/2)*pow(x, n/2)*x : pow(x, n/2)*pow(x, n/2);
    }
}
