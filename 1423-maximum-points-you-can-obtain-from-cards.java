class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0, score = 0;
        for(int i = 0; i < k; i++) {
            lsum += cardPoints[i];
            score = lsum;
        }

        int minLen = n-1;
        for(int i=k-1; i>=0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[minLen];
            minLen--;
            score = Math.max(score, lsum + rsum);
        }

        return score;
    }
}