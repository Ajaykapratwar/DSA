class Solution {
    public int rev(int n){
        if(n/10 == 0) return n;
        StringBuilder s = new StringBuilder(Integer.toString(n));
        s.reverse();
        return Integer.parseInt(s.toString());
    }
    public int mirrorDistance(int n) {
       return Math.abs(n - rev(n));
    }
}