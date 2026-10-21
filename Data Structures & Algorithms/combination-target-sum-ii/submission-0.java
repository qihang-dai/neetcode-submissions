class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<Integer>());
        return res;
    }

    void dfs(int start, int[] candidates, int target, List<Integer> tmp){
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            tmp.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i], tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


}
