class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int count = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                if(grid[i][j] == '1'){ // is there any land?
                    count++;

                    // all directions call
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    void dfs(char [][] grid, int i, int j){
        // mark the current cell as visited
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0' ){
            return; //backtracking
        }
        grid[i][j] = '0'; // land is sinked, marked as visited 
        dfs(grid, i+1, j); //Move dowm
        dfs(grid, i-1, j); // Move up
        dfs(grid, i, j+1); // move right
        dfs(grid, i, j-1); // move right
    }
}