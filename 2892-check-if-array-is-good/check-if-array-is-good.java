class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int max = nums[n-1];
        if(n != max + 1) return false;

        for(int i = 0; i < n-2; i++) {
            if(nums[i] != i+1) {
                return false;
            }
        }

        return (nums[n-2] == max && nums[n-1] == max);
    }
}