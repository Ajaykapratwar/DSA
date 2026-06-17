class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];

        long cur = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                cur++;
            } else if (ch == '*') {
                if (cur > 0) cur--;
            } else if (ch == '#') {
                cur *= 2;
            }

            len[i] = cur;
        }

        if (k >= cur) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long currLen = len[i];
            long prevLen = (i == 0) ? 0 : len[i - 1];

            if (Character.isLetter(ch)) {
                if (k == currLen - 1) {
                    return ch;
                }
            }
            else if (ch == '*') {
                if (prevLen > currLen && k == currLen) {
                    k = prevLen - 1;
                }
            }
            else if (ch == '#') {
                long half = currLen / 2;
                if (k >= half) {
                    k -= half;
                }
            }
            else if (ch == '%') {
                if (currLen > 0) {
                    k = currLen - 1 - k;
                }
            }
        }

        return '.';
    }
}