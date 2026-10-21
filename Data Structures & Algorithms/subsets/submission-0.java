class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> path = new ArrayList();
        dfs(nums, 0, path);
        return res;
    }
    
    void dfs(int[] nums, int startIndex, List<Integer> path){
        res.add(new ArrayList(path));
        for(int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.removeLast();
        }
    }
}
