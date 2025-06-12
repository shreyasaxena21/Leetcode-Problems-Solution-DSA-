class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        //left to right
        // top to bottom;
        // right tot left
        // bottom to up
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        while(left <= right && top <= bottom){
            //step 1 left to right
            for(int j = left ; j<=right; j++){
                result.add(matrix[top][j]);
            }

            //shrink the row
            top++;

            //step 2 top to bottom
            for(int j = top ; j<=bottom; j++){
                result.add(matrix[j][right]);
            }

            //shrink the right
            right--;

            if(top<=bottom){
                //step 3 right to left
                for(int j = right; j>=left; j--){
                    result.add(matrix[bottom][j]);
                }
            }

            //shrink the bottom
            bottom--;

            if(left<=right){
                //step 4 bottom to up
                for(int j = bottom; j>= top; j--){
                    result.add(matrix[j][left]);
                }
            }

            //shrink left
            left++;
        }

        return result;
    }
}