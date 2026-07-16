class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] prefixGcd = new int[n];

        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        for(int i = 0; i < n/2; i++) {
            sum += gcd(prefixGcd[i], prefixGcd[n-1-i]);
        }

        return sum;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}