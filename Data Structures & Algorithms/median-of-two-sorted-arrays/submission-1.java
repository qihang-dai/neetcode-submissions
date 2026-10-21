class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int half = (m + n + 1)/2;
        if(nums1.length > nums2.length){
            //assuming
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = m;
        while(left <= right){
            int i = (left + right)/2;
            int j = half - i;
            int L1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int L2 = j == 0? Integer.MIN_VALUE : nums2[j - 1];
            int R1 = i == m? Integer.MAX_VALUE : nums1[i];
            int R2 = j == n? Integer.MAX_VALUE : nums2[j];

            if(L1 <= R2 && L2 <= R1){
                if((m + n)%2 != 0){
                    //odd
                    return Math.max(L1, L2);
                }else{
                    //even
                    return (Math.max(L1,L2) + Math.min(R1,R2))/2.0;
                }
            }else if (L1 > R2){
                // over pick left, push to left
                right = i - 1;
            }else{
                //over pick right, push to right
                left = i + 1;
            }
        }
        return 0.0;
    }
}
