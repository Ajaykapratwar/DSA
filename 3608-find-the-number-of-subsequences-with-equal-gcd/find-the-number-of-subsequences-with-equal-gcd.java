class Solution {

    private static final long MOD = 1000000007;
    int gcd(int a,int b){
        if(a==0)
            return b;
        if(b==0)
            return a;
        int i=Math.min(a,b);
        for(;i>=1;i--){
            if(a%i==0 && b%i==0)
                return i;
        }
        return 1;
    }
    long helper(int[] nums,int index,int first,int second,long[][][] dp){
        if(index==nums.length){
            if(first==0 || second==0)
                return 0;
            if(first==second)
                return 1;
            return 0;
        }
        if(dp[index][first][second]!=-1)
            return dp[index][first][second];
        long skip=helper(nums,index+1,first,second,dp);
        long take1=helper(nums,index+1,gcd(nums[index],first),second,dp);
        long take2=helper(nums,index+1, first,gcd(nums[index],second),dp);

        return dp[index][first][second] = (skip + take1 + take2) % MOD;
    }
    public int subsequencePairCount(int[] nums) {
        int n=nums.length;
        int maxy=Integer.MIN_VALUE;
        for(int i:nums)
            maxy=Math.max(i,maxy);

        long[][][] dp=new long[n+1][maxy+1][maxy+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=maxy;j++){
                for(int k=0;k<=maxy;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return (int) (helper(nums, 0, 0, 0, dp) % MOD);
    }
}