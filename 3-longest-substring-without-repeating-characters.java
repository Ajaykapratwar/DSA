class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0, left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch)+1);
            }

            map.put(ch, right);

            int len = right - left + 1;
            maxlen = Math.max(len, maxlen);
        }

        return maxlen;
    }
}