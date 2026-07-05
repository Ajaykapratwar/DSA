class Solution {
    int[][][] dp;
    int[][] dir = {{-1, 0}, {0, -1}, {-1, -1}};
    int MOD = 1000000007;
    public int[] solve(List<String> board, int i, int j){
        if(i<0 || j<0) return new int[]{Integer.MIN_VALUE, 0}; // invalid cell
        if(i==0 && j==0) return new int[]{0, 1}; // end reached

        if(dp[i][j][0]!=-1) return new int[]{dp[i][j][0], dp[i][j][1]}; // memo

        int max = 0;
        long ways = 0;
        char ch = board.get(i).charAt(j)=='S'? '0' : board.get(i).charAt(j); // curr character
        if(ch=='X') return new int[]{Integer.MIN_VALUE, 0}; // blocked
        int num = ch-'0'; // curr digit
        for(int[] d : dir){
            int x = i+d[0];
            int y = j+d[1];
            int[] ans = solve(board, x, y);
            if(ans[1]==0) continue;
            int sum = num + ans[0];
            long currWays = ans[1];

            if(max<sum){
                max = sum;
                ways = currWays;
            }else if(max==sum){
                ways += currWays;
            }
        }
        return dp[i][j] = new int[]{max, (int)(ways%MOD)};
    }
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m = board.get(board.size()-1).length();
        dp = new int[n][m][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int[] res = solve(board, n-1, m-1);
        return res[1]==0? new int[]{0, 0} : res;
    }
}