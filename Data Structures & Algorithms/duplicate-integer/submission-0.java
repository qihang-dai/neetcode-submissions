class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            boolean dup = set.add(n);
            if(!dup) return true;
        }
        return false;
    }
}