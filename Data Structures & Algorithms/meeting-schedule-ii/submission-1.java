/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        int res = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(Interval inter: intervals){
            heap.offer(inter.end);
            if(inter.start >= heap.peek()) {
                heap.poll();
            }
            res = Math.max(heap.size(), res);
        }
        return res;
    }
}
