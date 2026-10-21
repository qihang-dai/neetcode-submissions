class Solution {
    public boolean canJump(int[] nums) {
        int cur = 0;
        int maxReach = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach,i + nums[i]);
        }
        return true;
    }
}
