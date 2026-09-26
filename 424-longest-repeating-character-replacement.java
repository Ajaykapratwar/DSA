class Solution {
    public int characterReplacement(String s, int k) {
        int maxfreq = 0, maxlen = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxfreq = Math.max(maxfreq, map.get(ch));

            while((right - left + 1) - maxfreq > k) {
                char ch2 = s.charAt(left);

                map.put(ch2, map.get(ch2) - 1);
                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}