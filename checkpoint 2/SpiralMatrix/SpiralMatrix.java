public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[] dr = {0, 1, 0, -1}; // row movement: right, down, left, up
        int[] dc = {1, 0, -1, 0}; // col movement: right, down, left, up
        boolean[][] visited = new boolean[n][n];

        int r = 0, c = 0, dir = 0;

        for (int num = 1; num <= n * n; num++) {
            matrix[r][c] = num;
            visited[r][c] = true;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) {
                dir = (dir + 1) % 4; // change direction
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
        }

        return matrix;
    }
}
