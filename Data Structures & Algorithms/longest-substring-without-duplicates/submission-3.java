class Solution {
    public int lengthOfLongestSubstring(String s) {
        //precondtion:i, j 
        //action:move j
        //once find duplicate, move i up until its no duplicate, we move i to j and start again, count the max Length along theway
        //how to find duplicate? maintain a hashSet, when reset, use a new Set
        //post condition: Till j reach the ends;

        int i = 0, j = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(j < s.length()){
            while(set.contains(s.charAt(j))){
                res = Math.max(res, j - i); // the previous one are nonDuplicate
                set.remove(s.charAt(i));
                i++;// move i until the set has no duplicate,

            }
            set.add(s.charAt(j));
            j++;
        }
        System.out.println(j);
        System.out.println(i);

        res = Math.max(j - i, res);
        return res;
    }
}
