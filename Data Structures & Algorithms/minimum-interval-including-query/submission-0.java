class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        Integer[] idx = new Integer[queries.length];
        for(int i = 0; i < queries.length; i++) idx[i] = i;
        Arrays.sort(idx, (a,b) -> Integer.compare(queries[a], queries[b]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int i = 0;
        int[] res = new int[queries.length];
        for(int qid : idx){
            int q = queries[qid];
            while(i < intervals.length && intervals[i][0] <= q) {
                heap.add(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }
            while(!heap.isEmpty() && heap.peek()[1] < q){
                heap.poll();
            }
            int queryresult = heap.isEmpty()? -1: heap.peek()[0];
            res[qid] = queryresult;
        }
        return res;
    }
}
