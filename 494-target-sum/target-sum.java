class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (Math.abs(target) > sum) return 0;

        int[][] dp = new int[n][2 * sum + 1];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solver(n-1, target, nums, dp, sum);
    }

    public int solver(int i, int target, int[] nums, int[][] dp, int sum) {
        if (target < -sum || target > sum) return 0;
        
        if (i == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == nums[0] || target == -nums[0]) return 1;
            return 0;
        }

        if(dp[i][target+sum] != -1) return dp[i][target+sum];

        int minus = solver(i-1, target+nums[i], nums, dp, sum);
        int plus = solver(i-1, target-nums[i], nums, dp, sum);

        dp[i][target+sum] = minus + plus;

        return dp[i][target+sum];
    }
}