class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int totalCells = n*m;
        k %= totalCells;

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j < m; j++) {
                row.add(0);
            }
            result.add(row);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int oldIndex = i*m+j;

                int newIndex = (oldIndex + k) % totalCells;

                int newRow = newIndex/m;
                int newColumn = newIndex%m;

                result.get(newRow).set(newColumn, grid[i][j]);
            }
        }

        return result;
    }
}