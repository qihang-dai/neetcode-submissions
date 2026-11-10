class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26], countt = new int[26];
        for(char c : s.toCharArray()){
            counts[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            countt[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(counts[i] != countt[i]) return false;
        }
        return true;
    }
}
