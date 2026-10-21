class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        return pow(x, n);
    }
    private double pow(double x, int n){
        if(n == 0) return 1;
        double half = pow(x, n/2);
        return n % 2 == 1? half * half * x : half * half ;
    }
}
