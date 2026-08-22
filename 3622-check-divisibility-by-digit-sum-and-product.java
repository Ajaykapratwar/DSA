class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1;
        int temp = n;

        while(n != 0) {
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n /= 10;
        }

        if(temp % (sum+product) == 0) return true;

        return false;
    }
}