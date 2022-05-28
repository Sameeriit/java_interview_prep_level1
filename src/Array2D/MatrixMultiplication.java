package Array2D;
import java.util.*;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        int [][]a1 = new int[r1][c1];

        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c1; j++){
                a1[i][j] = sc.nextInt();
            }
        }

        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int [][]a2 = new int[r2][c2];

        for(int i = 0; i < r2; i++){
            for(int j = 0; j < c2; j++){
                a2[i][j] = sc.nextInt();
            }
        }

        if( c1 != r2){
            System.out.println("Invalid input");
            return;
        }

        int [][] product = new int[r1][c2];

        for(int row = 0; row < product.length; row++){
            for(int col = 0; col < product[0].length; col++){
                for(int fill = 0; fill < r1; fill++){
                    product[row][col] += a1[row][fill] * a2[fill][col];
                }
            }
        }

        for(int row = 0; row < product.length; row++){
            for(int col = 0; col < product[0].length; col++){
                System.out.print(product[row][col]);
            }
            System.out.println();
        }



    }
}
