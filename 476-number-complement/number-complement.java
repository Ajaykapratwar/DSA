class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') sb.append('0');
            else sb.append('1');
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}