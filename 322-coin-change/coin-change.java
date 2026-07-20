class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = solver(n-1, amount, coins, dp);

        return ans >= (int)1e9 ? -1: ans;
    }

    public int solver(int i, int target, int[] coins, int[][] dp) {
        int INF = (int)1e9;

        if(i == 0) {
            if(target % coins[i] == 0) return target / coins[i];
            else return INF;
        }

        if(dp[i][target] != -1) return dp[i][target];

        int notTake = 0 + solver(i-1, target, coins, dp);

        int take = INF;
        if(coins[i] <= target) {
            take = 1 + solver(i, target-coins[i], coins, dp);
        }

        dp[i][target] = Math.min(notTake, take);

        return dp[i][target];
    }
}