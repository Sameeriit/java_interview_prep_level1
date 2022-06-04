package Array2D;
import java.util.*;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();

            }
        }

        for(int i = 0; i < arr.length; i++){
            int svj = 0;                         // smallest value of j
            for(int j = 1; j < arr[0].length; j++){
                if(arr[i][j] < arr[i][svj]){
                    svj = j;
                }
            }
            boolean flag = true;
            for(int k = 0; k < arr.length; k++){
                if(arr[k][svj] > arr[i][svj]) {
                    flag = false;
                    break;
                }

            }
            if(flag == true){
                System.out.println(arr[i][svj]);
                return;
            }
        }
        System.out.println("Invalid Input");

    }
}
