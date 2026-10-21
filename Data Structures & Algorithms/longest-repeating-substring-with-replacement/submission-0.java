class Solution {
    public int characterReplacement(String s, int k) {
        //precondition:i, j, move to increase subString
        //action: we move i and j, keep track of 2 
            //1. the length, 2. the count of the mostFrequent within the subString. can be done via a Map
            // invariant: if the subString - countOf mostFrequent < k, 
            //          we can fill up to the substring length
            // else, we need to move the i up, until the invariant tracks again
        // howTokeep the mostCount? map
        //postCondition: i moved up, till substring - mostFreq < 

        Map<Character, Integer> count = new HashMap<>();
        int maxFreq = 0;
        int res = 0;

        int i = 0, j = 0;

        while(j < s.length()){
            char cur = s.charAt(j);
            count.put(cur, count.getOrDefault(cur, 0) + 1);
            if(count.get(cur) > maxFreq){
                maxFreq = count.get(cur);
            }
            while(j - i + 1 - maxFreq > k){
                char ichar = s.charAt(i);
                i++;
                count.put(ichar, count.get(ichar) - 1);
                if(count.get(ichar) + 1 == maxFreq){//redo the MaxChar
                    maxFreq--;
                    for(Map.Entry<Character, Integer> entry : count.entrySet()){
                        maxFreq = Math.max(entry.getValue(), maxFreq);
                    }
                }
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
