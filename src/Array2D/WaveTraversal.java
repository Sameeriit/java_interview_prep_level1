package Array2D;

import java.util.*;

/**
 * question 3 wave traversal form pepcoding
 *   wave traversal problem solution
 *   author : sameer ahmad
 *   date : 29/05/2022
 */

public class WaveTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][]arr = new int[n][m];

        for(int row = 0; row < arr.length; row++ ){
            for(int col = 0; col < arr[0].length; col++){
                arr[row][col] = sc.nextInt();
            }
        }

        for(int col = 0; col < arr[0].length; col++){

            if(col % 2 == 0){   // if col are even then row are going to increase
                for(int row = 0; row < arr.length; row++){
                    System.out.println(arr[row][col]);
                }

            }else{     // col are odd then its row is going to decrease
                for(int row = arr.length -1; row >=0; row--) {
                    System.out.println(arr[row][col]);
                }
            }

        }



    }
}
