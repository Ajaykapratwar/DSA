class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven = 0;

        sumOdd = n*n;
        sumEven = (n*n)+n;

        return gcd(sumOdd, sumEven);
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}