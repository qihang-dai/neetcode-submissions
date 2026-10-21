class KthLargest {
    PriorityQueue<Integer> heap;
    int kth;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.kth = k;

        for(int n : nums){
            if(heap.size() < k) heap.add(n);
            else if(heap.size() == k && n > heap.peek()){
                heap.poll();
                heap.add(n);
            }
        }
    }
    
    public int add(int val) {
        if(heap.size() < kth){
            heap.add(val);
        } else if(heap.size() == kth && val > heap.peek()){
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}
