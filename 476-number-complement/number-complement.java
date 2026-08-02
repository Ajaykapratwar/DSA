class Solution {
    public int findComplement(int num) {
        String s = "";
        StringBuilder sb = new StringBuilder();

        while(num != 1) {
            int rem = num % 2;
            num /= 2;
            sb.append(rem);
        }
        sb.append(num);
        s = sb.reverse().toString();

        String temp = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') temp = temp + "0";
            if(s.charAt(i) == '0') temp = temp + "1";
        }

        int n = temp.length(), p2 = 1, ans = 0;

        for(int i = n-1; i>=0; i--) {
            if(temp.charAt(i) == '1') {
                ans += p2;
            }
            p2 *= 2;
        }
        return ans;
    }
}