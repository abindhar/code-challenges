public class setMatrixZeros {
    // #73 : Set Matrix Zeros
    public void Solution(int[][] matrix) {
        /* Most efficient solution: Use first row and col as memory
        Time:
        Space:
        */
        int rows = matrix.length, cols = matrix[0].length;
        Boolean first_col = false; // flag to indicate if the first column is to be zeroed
        // First pass
        for (int r=0; r<rows; r++){
            if (matrix[r][0]==0)
                first_col = true;
            for (int c=1; c<cols; c++){
                if (matrix[r][c]==0){
                    matrix[r][0] = 0; // First elem in this row is now 0
                    matrix[0][c] = 0; // First elem in this col is now 0
                }
            }
        }
        // Second Pass, now set zeros
        //print(matrix);
        // Check elements from row1 col1 to end
        for (int r=1; r<rows;r++){
            for (int c=1; c<cols;c++){
                // For matrix[r][c] check if either this row or col needs to be zero
                if (matrix[r][0]==0 || matrix[0][c]==0)
                    matrix[r][c] = 0;
            }
        }
        // Set first row zero if required, matrix[0][0] is cell that decides if row 0
        // needs to be zeroed
        if (matrix[0][0]==0){
            for (int c=0; c<cols;c++)
                matrix[0][c] = 0;
        }
        // Set first column to zero if required
        if (first_col){
            for (int r=0; r<rows; r++)
                matrix[r][0] = 0;
        }
    }
    public void print(int[][] matrix){
        int rows = matrix.length, cols = matrix[0].length;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
