class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, 0, 0);
        return res;
    }

    void dfs(String tmp, int n, int left, int right){
        
        if(tmp.length() == n * 2){
            res.add(tmp);
        }

        if(left < n) {
            dfs(tmp + "(", n, left + 1, right);
        }
        if(right < left) {
            dfs(tmp + ")", n, left, right + 1);
        }
    }
}
