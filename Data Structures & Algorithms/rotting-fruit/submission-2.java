class Solution {
    public int orangesRotting(int[][] grid) {
        int allFresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
    
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1){
                    allFresh++;
                }
            }
        }


        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int round = 0;

        while(!q.isEmpty() && allFresh > 0){
            int size = q.size();
            round++;

            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];

                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1){
                        continue;
                    }
                    grid[x][y] = 2;
                    allFresh--;
                    q.offer(new int[]{x,y});
                }
            }
        }

        if(allFresh != 0) return -1;
        return round;
    }
}
