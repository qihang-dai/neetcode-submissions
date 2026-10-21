class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int height = matrix.length;
        int width = matrix[0].length;


        int x = 0;
        int y = 0;
        int d = 0;

        int[][] direction = {
            {0, 1}, 
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int count = width * height;
        for (int i = 0; i < count; i++) {
            result.add(matrix[x][y]);
            matrix[x][y] = 999;
            int nextX = x + direction[d][0];
            int nextY = y + direction[d][1];

            if(
                nextX < 0 || nextX >= height ||
                nextY < 0 || nextY >= width ||
                matrix[nextX][nextY] == 999
            ) {
                d = (d + 1) % 4;
                nextX = x + direction[d][0];
                nextY = y + direction[d][1];
            }
            x = nextX;
            y = nextY;
        }

        return result;
    }
}