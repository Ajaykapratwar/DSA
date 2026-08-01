class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for(int[] row: dp) Arrays.fill(row, -1);

        return solver(0, nums.length-1, nums, dp) >= 0;
    }

    public static int solver(int i, int j, int[] nums, int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];

        if(i == j) return dp[i][j] = nums[i];

        return dp[i][j] = Math.max(
            nums[i] - solver(i+1, j, nums, dp),
            nums[j] - solver(i, j-1, nums, dp)
        );
    }
}