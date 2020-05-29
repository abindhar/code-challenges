public class sparseMatrixMultiply {
    public int[][] Solution(int[][] A, int[][] B) {

        // Optimal solution: Assume matrices are huge. Preprocess them ie compress
        // to a [ idx, val ...] representation of only non zero values, then multiply
        return optimal(A, B);

        //return better(A, B);

        // Naive solution
        // Time:
        // int A_rows = A.length, A_cols = A[0].length, B_cols = B[0].length;
        // int[][] C = new int[A_rows][B_cols];
        // for (int i=0; i<A_rows; i++){
        //     for (int j=0; j<A_cols; j++){
        //         for (int k=0; k<B_cols; k++){
        //             C[i][k] += A[i][j] * B[j][k];
        //         }
        //     }
        // }
        // return C;
    }
    public int[][] better(int[][] A, int[][] B){
        int A_rows = A.length, A_cols = A[0].length, B_cols = B[0].length;
        int[][] C = new int[A_rows][B_cols];
        //printMatrix(C);
        for (int i=0; i<A_rows; i++){
            for (int j=0; j<A_cols; j++){
                if (A[i][j]!=0){
                    for (int k=0; k<B_cols; k++){
                        if (B[j][k]!=0){
                            C[i][k] += A[i][j] * B[j][k];
                        }

                    }
                }
            }
        }
        return C;
    }

    public void printMatrix(int[][] matrix){
        // Print a 2D Matrix Utility
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }


    public int[][] optimal(int[][] A, int[][] B){
        // Optimal solution
        int m = A.length, n = B[0].length;
        int[][] C = new int[m][n];
        //Pre processing
        ArrayList<ArrayList<Integer>> A_sparse = rowCompress(A);
        ArrayList<ArrayList<Integer>> B_sparse = colCompress(B);
        // Sparse multiplication
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                C[i][j] = sparseMul(A_sparse.get(i), B_sparse.get(j));
            }
        }
        return C;
    }

    public int sparseMul(ArrayList<Integer> A_row, ArrayList<Integer> B_col){
        /*
        Algo: Two pointers
        Time: O(row + col)
        */
        int i = 0, j = 0, ans = 0; //Two pointers
        int m = A_row.size(), n = B_col.size();
        if (m==0 || n==0)
            return 0;
        while (i<m && j<n){
            if (A_row.get(i)==B_col.get(j)){
                ans += A_row.get(i+1) * B_col.get(j+1);
                i+=2;
                j+=2;
            } else if (A_row.get(i)<B_col.get(j)){
                i+=2;
            } else {
                j+=2;
            }
        }
        return ans;

    }

    public ArrayList<ArrayList<Integer>> rowCompress(int[][] A){
        // Return row compressed version of matrix
        int rows = A.length, cols = A[0].length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<rows; i++)
            ans.add(new ArrayList<Integer>());
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (A[i][j]!=0){
                    ans.get(i).add(j);
                    ans.get(i).add(A[i][j]);
                }

            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> colCompress(int[][] A){
        // Return col compressed version of matrix
        int rows = A.length, cols = A[0].length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<cols; i++)
            ans.add(new ArrayList<Integer>());
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (A[i][j]!=0){
                    ans.get(j).add(i);
                    ans.get(j).add(A[i][j]);
                }
            }
        }
        return ans;
    }
}
