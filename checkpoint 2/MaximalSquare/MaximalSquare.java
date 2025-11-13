public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[] dp = new int[cols + 1]; // extra space for easier indexing
        int maxSide = 0, prev = 0;

        for (int i = 0; i < rows; i++) {
            prev = 0; // dp[i-1][j-1] value
            for (int j = 0; j < cols; j++) {
                int temp = dp[j + 1]; // store current dp[j+1] before updating
                if (matrix[i][j] == '1') {
                    dp[j + 1] = 1 + Math.min(Math.min(dp[j], dp[j + 1]), prev);
                    maxSide = Math.max(maxSide, dp[j + 1]);
                } else {
                    dp[j + 1] = 0;
                }
                prev = temp;
            }
        }

        return maxSide * maxSide;
    }
}
