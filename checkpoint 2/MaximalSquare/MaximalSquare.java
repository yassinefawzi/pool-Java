public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

		int cols = matrix[0].length;
        int[] dp = new int[cols + 1];
        int maxSide = 0, prev = 0;

        for (char[] row : matrix) {
            prev = 0;
            for (int j = 0; j < cols; j++) {
                int temp = dp[j + 1];
                dp[j + 1] = row[j] == '1' ? 1 + Math.min(Math.min(dp[j], dp[j + 1]), prev) : 0;
                prev = temp;
                maxSide = Math.max(maxSide, dp[j + 1]);
            }
        }

        return maxSide * maxSide;
    }
}
