class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> mpp = new HashMap<>();
        int n = nums.length;
        
        if (n <= 2) return -1;
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            mpp.putIfAbsent(nums[i], new ArrayList<>());
            mpp.get(nums[i]).add(i);
        }

        for (List<Integer> indices : mpp.values()) {
            if (indices.size() < 3) continue;
            
            for (int i = 0; i + 2 < indices.size(); i++) {
                int dist = 2 * (indices.get(i + 2) - indices.get(i));
                ans = Math.min(ans, dist);
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}