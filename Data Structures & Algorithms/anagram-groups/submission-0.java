class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] hash = new int[26];
            for(char c : s.toCharArray()){
                hash[c - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(hash), k -> new ArrayList()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
