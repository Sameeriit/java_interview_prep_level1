package recursion.backtracking;

public class NQueen {

    public static void printNqueen(int[][] chess,String qsf,int row){
        if(row == chess.length){
            System.out.println(qsf+ ".");
            return;
        }

        for(int col = 0; col < chess.length; col++) {
            if (isQueensafe(chess, row, col) == true) {
                chess[row][col] = 1;
                printNqueen(chess, qsf + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;

            }
        }
    }
    public static boolean isQueensafe(int[][]chess,int row ,int col){

        //up
        for(int i = row - 1,j = col; i >= 0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }


        // diagonally left
        for(int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j-- ){
            if(chess[i][j] == 1){
                return false;
            }
        }
        //diagonally right
        for(int i = row - 1,j = col + 1; i>=0 && j < chess.length; i--,j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {

    }

}
