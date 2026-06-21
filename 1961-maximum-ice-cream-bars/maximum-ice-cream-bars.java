class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int icecream = costs.length;
        
        for(int i = 0; i < icecream; ++i) {
            if(coins < costs[i]) {
                return i;
            }
            coins -= costs[i];
        }

        return icecream;
    }
}