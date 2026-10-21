class Solution {
    public int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int bottom = stack.pop();
                if(stack.isEmpty()) continue;
                int left = stack.peek();
                int right = i;
                int h = Math.min(height[left], height[right]) - height[bottom];
                int w = right - left - 1;
                res += w*h;
            }
            stack.push(i);
        }
        return res;

    }
}
