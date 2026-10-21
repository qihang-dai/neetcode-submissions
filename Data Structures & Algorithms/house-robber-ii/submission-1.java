class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), 
                        rob(nums, 1, nums.length));
    }


    public int rob(int[] nums, int start, int end ) {
        int prevOne = 0;
        int prevTwo = 0;
        for(int i = start; i < end; i++){
            int cur = Math.max(prevOne, prevTwo + nums[i]);
            prevTwo = prevOne;
            prevOne = cur; 
        }

        return prevOne;
    }
}
