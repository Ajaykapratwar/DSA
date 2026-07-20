class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = solver(n-1, amount, coins, dp);

        return ans;
    }

    public int solver(int i, int target, int[] coins, int[][] dp) {
        if(i == 0) return target % coins[0] == 0 ? 1 : 0;

        if(dp[i][target] != -1) return dp[i][target];

        int notTake = solver(i-1, target, coins, dp);

        int take = 0;
        if(coins[i] <= target) {
            take = solver(i, target-coins[i], coins, dp);
        }

        dp[i][target] = (notTake + take);

        return dp[i][target];
    }
}