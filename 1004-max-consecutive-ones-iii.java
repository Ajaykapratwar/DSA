class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0, len = 0, left = 0;
        int zeros = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeros++;
            }

            while(zeros > k) {
                if(nums[left] == 0) zeros--;
                left++;
            }
            
            len = right - left + 1;
            maxlen = Math.max(len, maxlen);
        }

        return maxlen;
    }
}