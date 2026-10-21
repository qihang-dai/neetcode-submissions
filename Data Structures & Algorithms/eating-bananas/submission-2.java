class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = 0;
        for(int p : piles){
            right = Math.max(p, right);
        }
        while(left < right){
            int mid = (left + right) / 2;
            int hourNeed = sumHour(piles, mid);
            if(hourNeed <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
        
    }

    int sumHour(int[] piles, int speed){
        int sum = 0;
        for(int p : piles){
            sum += (p + speed - 1) / speed;
        }
        return sum;
    }
}
