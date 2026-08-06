class Solution {
    public int smallestNumber(int n, int t) {
        while(productOfDigits(n) % t != 0) {
            n++;
        }

        return n;
    }

    public int productOfDigits(int n) {
        int product = 1;

        while(n != 0) {
            int rem = n % 10;
            n /= 10;
            product *= rem;
        }

        return product;
    }
}