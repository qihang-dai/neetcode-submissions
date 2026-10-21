class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int res = 0, n = heights.length;
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])){
                int prev = stack.pop();
                int h = heights[prev];
                int left = stack.isEmpty()? -1 : stack.peek();
                int w = i - left - 1;
                int area = w * h;
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }
}
