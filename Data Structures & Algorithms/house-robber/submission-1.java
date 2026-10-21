class Solution {
    public int rob(int[] nums) {
        if(nums.length > 2){
            nums[2] += nums[0];
        }
        for(int i = 3; i < nums.length; i++){
            nums[i] += Math.max(nums[i - 2], nums[i -3]);
        }

        int maxRob = 0;
        for(int n : nums){
            maxRob = Math.max(n, maxRob);
        }
        return maxRob;
    }
}
