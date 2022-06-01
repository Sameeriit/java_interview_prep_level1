package Array2D;
import java.util.*;

/** Documentation..!
 * problem state of wakanda 2 from pep coding or upper triangular  diagonal traversal
 * solution   state of wakanda 2
 * Author : Sameer Ahamd
 * date : 1 /05 /2022
 */

public class StateOfWakanda2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][]arr = new int[n][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; i++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int gap = 0; gap < arr[0].length; gap++){
            for(int row = 0,col = gap ; col < arr[0].length; row++,col++){
                System.out.println(arr[row][col]);

            }
        }


    }
}
