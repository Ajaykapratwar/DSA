class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        char[] ans = new char[s.length()];

        for(int i = 0; i < indices.length; i++) {
            char temp = s.charAt(i);
            int idx = indices[i];
            ans[idx] = temp;
        }
        for(char temp: ans) sb.append(temp);

        return sb.toString();
    }
}