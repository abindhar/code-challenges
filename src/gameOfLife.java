public class gameOfLife {
    public void Solution(int[][] board) {
        /* Algo: Two Pass
        Use dummy value 2, 3 to change board state
        2 => Was dead make it alive
        3 => Was alive make it dead
        */
        int rows = board.length, cols = board[0].length;
        int live_ngbrs;
        // First Pass
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                live_ngbrs = liveNeighbors(board, r, c, rows, cols);
                if (board[r][c]==0 && live_ngbrs==3)
                    board[r][c] = 2; // dead to alive
                else if (board[r][c]==1 && (live_ngbrs<2 || live_ngbrs>3))
                    board[r][c] = 3;
            }
        }
        // Second Pass, process and change to final state
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                if (board[r][c]==3)
                    board[r][c] = 0;
                else if (board[r][c]==2)
                    board[r][c] = 1;
            }
        }
    }
    public int liveNeighbors(int[][] board, int r, int c, int rows, int cols){
        /* Counts number of live neighbors
        board[r][c]==1 || board[r][c]==3 both count, state 3 means previously alive
        */
        int ans = 0, nr, nc;
        int[][] dirs = {
                {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };
        for (int[] dir : dirs){
            nr = r + dir[0];
            nc = c + dir[1];
            if ((0<=nr) && (nr<rows) && (0<=nc) && (nc<cols) && (board[nr][nc]==1 || board[nr][nc]==3))
                ans++;
        }
        return ans;
    }
}
