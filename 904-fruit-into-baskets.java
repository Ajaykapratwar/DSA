class Solution {
    public int totalFruit(int[] fruits) {
        //your code goes here
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, maxcount = 0;
        int left = 0, n = fruits.length;

        for(int right = 0; right < n; right++) {

            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }
            
            count = right - left + 1;
            maxcount = Math.max(count, maxcount);
        }

        return maxcount;
    }
}