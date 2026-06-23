public class Solution {
    public int zigZagArrays(int n, int l, int r) {
        if (n == 1) {
            return r - l + 1;
        }
        
        long MOD = 1_000_000_007L;
        int m = r - l + 1;
        
        long[] dpUp = new long[m + 1];
        long[] dpDown = new long[m + 1];
        
        for (int v = 0; v < m; v++) {
            dpUp[v] = v;
            dpDown[v] = m - 1 - v;
        }
        
        for (int i = 3; i <= n; i++) {
            long[] nextUp = new long[m + 1];
            long[] nextDown = new long[m + 1];
            
            long[] prefDown = new long[m + 1];
            long sumDown = 0;
            for (int v = 0; v < m; v++) {
                sumDown = (sumDown + dpDown[v]) % MOD;
                prefDown[v] = sumDown;
            }
            
            long[] prefUp = new long[m + 1];
            long sumUp = 0;
            for (int v = 0; v < m; v++) {
                sumUp = (sumUp + dpUp[v]) % MOD;
                prefUp[v] = sumUp;
            }
            
            for (int v = 0; v < m; v++) {
                if (v > 0) {
                    nextUp[v] = prefDown[v - 1];
                }

                if (v < m - 1) {
                    long totalUp = prefUp[m - 1];
                    long excludeLower = prefUp[v];
                    nextDown[v] = (totalUp - excludeLower + MOD) % MOD;
                }
            }
            
            dpUp = nextUp;
            dpDown = nextDown;
        }
        
        long totalWays = 0;
        for (int v = 0; v < m; v++) {
            totalWays = (totalWays + dpUp[v] + dpDown[v]) % MOD;
        }
        
        return (int) totalWays;
    }
}