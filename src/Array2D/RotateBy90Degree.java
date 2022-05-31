package Array2D;
import java.util.*;

/**
 * problem rotate matrix by 90 degree
 * solution
 * Author : Sameer Ahmad
 * date : 31/05/2022
 */

public class RotateBy90Degree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][]arr = new int[n][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // transpose of matrix
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr[0].length; j++){      // traversing only on the upper triangular matrix
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // reverse the matrix so that it will rotate by 90 degree
        for(int i = 0; i < arr.length; i++){
            int li = 0 ;
            int ri = arr[0].length - 1;
            while(li < ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                li++;
                ri--;
            }
        }
        display(arr);

    }

    public static void display(int[][]arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
