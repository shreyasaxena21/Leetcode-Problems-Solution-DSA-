class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                if(grid[i][j] == 2 ){
                    queue.add(new int []{i,j});
                }

                else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        if(freshCount==0){
            return 0;
        }

        int minutes = 0;
        int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}}; // all 4 directions

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRotten = false;
            for(int i = 0; i<size; i++){
                int orangePosition [] = queue.poll();
                int r = orangePosition[0];
                int c = orangePosition[1];

                //check in all dire

                for(int [] direction : directions){
                    int newRowDirection = r + direction[0];
                    int newColDirection = c + direction[1];

                    if(newRowDirection>=0 && newRowDirection< rows && newColDirection>=0 && newColDirection<columns && grid[newRowDirection][newColDirection]==1){
                        grid[newRowDirection][newColDirection] = 2;
                        queue.add(new int[]{newRowDirection, newColDirection});
                        freshCount--;
                        isRotten = true;

                    }
                }// direction ends
            } // queue ends

            if(isRotten){
                minutes++;
            }
        }

        return freshCount==0 ? minutes : -1;
    }
}