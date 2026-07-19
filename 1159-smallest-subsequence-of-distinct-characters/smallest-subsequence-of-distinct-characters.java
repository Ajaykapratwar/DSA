class Solution {
    public String smallestSubsequence(String s) {
        int[] frequency = new int[26];
        for(char c: s.toCharArray()) {
            frequency[c-'a']++;
        }

        boolean[] trackChars = new boolean[26];
        
        char[] stack = new char[s.length()];
        int top = -1;
        for(char c: s.toCharArray()) {
            frequency[c-'a']--;

            if(!trackChars[c-'a']) {
                while(top>=0 && c<stack[top] && frequency[stack[top]-'a']>0) {
                    trackChars[stack[top]-'a'] = false;
                    top--;
                }
                stack[++top] = c;
                trackChars[c - 'a'] = true;
            }
        }
        return String.valueOf(stack, 0, top + 1);
    }
}