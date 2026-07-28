class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int n = nums.length;
       Map<Integer, Integer> table = new HashMap<>();

       for(int num: nums) {
        table.put(num, table.getOrDefault(num, 0) + 1);
       }

       List<Integer> ans = new ArrayList<>();

       for(Map.Entry<Integer, Integer> entry: table.entrySet()) {
        int key = entry.getKey();
        int value = entry.getValue();

        if(value > n/3) ans.add(key);
       }

       return ans;
    }
}