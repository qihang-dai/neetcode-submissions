class Solution {
    public List<Integer> partitionLabels(String s) {
        int cur = 0;
        int start = 0;
        Map<Character, Integer> charLastIndex = new HashMap<Character, Integer>();
        for(int i = s.length() - 1; i >= 0; i--) {
            charLastIndex.putIfAbsent(s.charAt(i), i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int curReach = 0;
        while(cur < s.length()) {
            curReach = Math.max(curReach, charLastIndex.get(s.charAt(cur)));
            if (curReach == cur) {
                res.add(cur - start + 1);
                start = cur + 1;
            }
            cur += 1;
        }
        return res;
    }
}
