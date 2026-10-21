class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        boolean[] hit = new boolean[3];
        for (int[] tri : triplets) {
            if(tri[0] > target[0] || tri[1] > target[1] || 
               tri[2] > target[2]) continue;
            hit[0] = hit[0] || tri[0] == target[0];
            hit[1] = hit[1] || tri[1] == target[1];
            hit[2] = hit[2] || tri[2] == target[2];
        }
        return hit[0] && hit[1] && hit[2];
    }
}
