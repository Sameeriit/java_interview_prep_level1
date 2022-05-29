package Array2D;
import java.util.*;

/**
 * question SpiralTraversal
 * solution of spiralTraversal problem
 * author : Sameer Ahmad
 * date : 29/05/2022
 */

public class SpiralTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] arr = new int[n][m];
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[0].length; col++){
                arr[row][col] = sc.nextInt();
            }
        }

        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;

        int tne = n * m ; // total number of input
        int count  = 0;

        while(count < tne) {   // loop run till count  and total number of element are equal :

            // for left wall

            for(int i = minr,j = minc;   i <= maxr && count < tne; i++){
                System.out.println(arr[i][j]);
                count ++;
            }
            minc++;


            // for bottom wall

            for(int i =maxr, j = minc; j <= maxc && count < tne; j++){
                System.out.println(arr[i][j]);
                count ++;
            }
            maxr--;

            // for right wall

            for(int i = maxr, j = maxc; i >= minr && count < tne;  i--){
                System.out.println(arr[i][j]);
                count ++;
            }
            maxc--;

            // for top wall

            for(int i = minr, j = maxc; j >= minc && count < tne; j--){
                System.out.println(arr[i][j]);
                count ++;
            }
            minr++;
        }

    }
}
