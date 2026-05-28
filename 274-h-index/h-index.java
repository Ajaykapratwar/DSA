class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        int h = 0;

        for(int i = 0; i < n; i++) {
            int paper = n - i;

            if(citations[i] >= paper) {
                h = paper;
                break;
            }
        }
        return h;
    }
}