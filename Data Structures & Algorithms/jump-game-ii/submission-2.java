class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int frontier = 0;
        int currentEnd = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            frontier = Math.max(frontier, i + nums[i]);
            if (i == currentEnd) {
                count++;
                currentEnd = frontier;
                if (currentEnd >= nums.length - 1) break;
            }
        }
        return count;
    }
}