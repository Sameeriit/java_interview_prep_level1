package Array2D;
import java.util.*;
/**
 * problem ExitPoint of the array
 * solution
 * Author : Sameer Ahmad
 * date : 31/05/2022
 */

public class ExitPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][]arr = new int[n][m];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int direction = 0;  // 0 : east , 1 : south , 2 : west , 3 : north
        int row = 0;
        int col = 0;
        while(true){
            direction = (direction + arr[row][col]) % 4;

            if(direction == 0){        // east
                col++;
            }else if(direction == 1){  // south
                row++;
            }else if(direction == 2){  // west
                col--;

            }else if(direction == 3){ // north
                row--;
            }

            if(row < 0){      // handling the case where we go out of array
                row++;
                break;
            }else if(col < 0){
                col++;
                break;

            }else if(row == arr.length){
                row--;
                break;
            }else if(col == arr[0].length){
                col--;
                break;
            }
        }
        System.out.println(row);
        System.out.println(col);
    }
}
