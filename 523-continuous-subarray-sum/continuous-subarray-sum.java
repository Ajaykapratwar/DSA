class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int runningSum = 0;

        for(int i = 0; i < nums.length; i++) {
            runningSum = (runningSum + nums[i]) % k;

            if(!map.containsKey(runningSum)) {
                map.put(runningSum, i);
            } else if(i - map.get(runningSum) > 1) {
                return true;
            }
        }
        return false;
    }
}