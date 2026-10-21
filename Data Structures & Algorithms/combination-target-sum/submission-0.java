class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<Integer> tmp =new ArrayList<>();
        dfs(0, tmp, target, nums);

        return res;
    }

    void dfs(int start, List<Integer> tmp, int target, int[] nums){
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            dfs(i, tmp, target - nums[i], nums);
            tmp.remove(tmp.size() - 1);
        }
    }
    
}
