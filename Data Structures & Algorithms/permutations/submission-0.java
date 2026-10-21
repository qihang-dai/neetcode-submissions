class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(0, nums, new LinkedHashSet<Integer>());
        return res;
    }

    void dfs(int start, int[] nums, Set<Integer> tmp){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(tmp.contains(nums[i])) continue;
            tmp.add(nums[i]);
            dfs(i + 1, nums, tmp);
            tmp.remove(nums[i]);
        }
    }
}
