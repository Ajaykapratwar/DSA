class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Boolean> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            map.put(num, true);
        }

        int n = nums.length;
        int total = max - min + 1;

        for(int i = min+1; i < max; i++) {
            if(!map.containsKey(i)) list.add(i);
        }

        return list;
    }
}