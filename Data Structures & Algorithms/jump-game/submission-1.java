class Solution {
    public boolean canJump(int[] nums) {
        int smallestIndexreachableToEnd = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if (nums[i] + i >= smallestIndexreachableToEnd){
                smallestIndexreachableToEnd = Math.min(i, smallestIndexreachableToEnd);
            }
        }
        return smallestIndexreachableToEnd == 0;
    }
}
