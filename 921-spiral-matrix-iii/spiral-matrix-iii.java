class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] arr = new int[rows*cols][2];

        int count = 0;
        int r = rStart, c = cStart;
        arr[count++] = new int[]{r, c};

        int steps = 1;

        while(count < rows*cols) {
            for(int i = 0; i < steps; i++) {
                c++;

                if(r >= 0 && r < rows && c >= 0 && c < cols) {
                    arr[count++] = new int[]{r, c};
                }
            }

            for(int i = 0; i < steps; i++) {
                r++;

                if(r >= 0 && r < rows && c >= 0 && c < cols) {
                    arr[count++] = new int[]{r, c};
                }
            }
            steps++;

            for(int i = 0; i < steps; i++) {
                c--;

                if(r >= 0 && r < rows && c >= 0 && c < cols) {
                    arr[count++] = new int[]{r, c};
                }
            }

            for(int i = 0; i < steps; i++) {
                r--;

                if(r >= 0 && r < rows && c >= 0 && c < cols) {
                    arr[count++] = new int[]{r, c};
                }
            }
            steps++;
        }
        return arr;
    }
}