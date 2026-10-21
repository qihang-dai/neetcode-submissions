class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        for(int rock : stones){
            q.add(rock);
        }

        while(q.size() > 1){
            int smash = q.poll() - q.poll();
            if(smash != 0) q.add(smash);
        }
        return q.isEmpty()? 0 : q.peek();
    }
}
