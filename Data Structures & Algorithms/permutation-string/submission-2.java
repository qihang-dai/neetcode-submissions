class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // count and subcount
        // if subcount not valid, move i up
        // valid: subCount <= count[i]
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int n = s1.length(), m = s2.length();
        if(m < n) return false;
        for(int i = 0; i < n; i++){
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        for(int i = n; i < m; i++){
            if(Arrays.equals(cnt1,cnt2)) return true;
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
        }
        return Arrays.equals(cnt1, cnt2);
    }
}
