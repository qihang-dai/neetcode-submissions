class Solution {
    public int rob(int[] nums) {

        int prevOne = 0;
        int prevTwo = 0;

        for(int i = 0; i < nums.length; i++){
            int cur = Math.max(prevOne, prevTwo + nums[i]);
            prevTwo = prevOne;
            prevOne = cur; 
        }

        return prevOne;
    }
}
