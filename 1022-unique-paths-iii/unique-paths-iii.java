class Solution {
    int totalCells = 0;

    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int startRow = 0, startCol = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != -1) totalCells++;
                
                if(grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        return solver(startRow, startCol, grid, 1);
    }

    public int solver(int i, int j, int[][] grid, int visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) return 0;

        if(grid[i][j] == 2) return visited == totalCells ? 1:0;
        
        int temp = grid[i][j];
        grid[i][j] = -1;

        int paths = 0;

        paths += solver(i-1, j, grid, visited + 1);
        paths += solver(i+1, j, grid, visited + 1);
        paths += solver(i, j-1, grid, visited + 1);
        paths += solver(i, j+1, grid, visited + 1);

        grid[i][j] = temp;

        return paths;
    }
}