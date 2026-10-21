class Solution {
    //pre: move a sliding window
    // invariant, get the max out of the window, while maintian it to be valuable everyTime
    // action: i ,j 
        // move j up, add index into monotonic decreasing queue;
        // move i once j is out of k window
        // if index oudated i is the top of the queue, remove it
        // record th cur i everyTime i~j reaches a K window
        //(move j first, then move i up)
    //post, a array has everyMaxVal within the window

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<Integer>();
        int i = 0, j = 0;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        while(j < nums.length){
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[j]){
                q.pollLast();
            }
            q.add(j);

            if(j - i + 1 == k){
                res[index++] = nums[q.peekFirst()];
                if(q.peek() == i){
                    q.pollFirst();
                }
                i++;
            }
            j++;
        }   

        return res;
    }
}
