package Array2D;
import java.util.*;

/**
 * problem state of wakanda 3 or lower triangular matrix
 * solution of state of wakanda 3
 * Author : Sameer Ahmad
 * date : 1/05/2022
 */

public class StateOfWakanda3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][]arr = new int[n][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int gap = 0; gap < arr.length; gap++){
            for(int row = gap, col = 0; row < arr.length; row++,col++){
                System.out.println(arr[row][col]);
            }
        }
    }
}
