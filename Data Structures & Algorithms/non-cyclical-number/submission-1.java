class Solution {
    public boolean isHappy(int n) {
        Set<Integer> appeared = new HashSet();
        while(!appeared.contains(n)){
            appeared.add(n);
            n = loop(n);
        }
        return n == 1;
    }

    private int loop(int n){
        int res = 0;
        while(n > 0){
            int digit = n %10;
            res += digit * digit;
            n = n/10;
        }
        return res;
    }
}
