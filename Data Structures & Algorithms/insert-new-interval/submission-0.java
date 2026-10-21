class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res= new ArrayList<>();
        int cur = 0;

        for(int[] interval : intervals) {
            if(newInterval[0] > interval[1])
                res.add(interval);
            else if (newInterval[1] < interval[0]) break;
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            cur++;
        }
        res.add(newInterval);
        while(cur < intervals.length){
            res.add(intervals[cur]);
            cur++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
