class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while(l < r){
            int tmp = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, tmp);
            // System.out.println(l + " " + r + " " + tmp);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
