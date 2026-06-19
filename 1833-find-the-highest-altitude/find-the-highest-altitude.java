class Solution {
    public int largestAltitude(int[] gain) {
        int[] arr = new int[gain.length+1];

        arr[0] = 0;
        int sum = 0;
        for(int i=0; i<gain.length; i++) {
            sum = sum + gain[i];
            arr[i+1] = sum;
        }

        int max = Integer.MIN_VALUE;

        for(int num: arr) {
            max = Math.max(max, num);
        }

        return max;
    }
}