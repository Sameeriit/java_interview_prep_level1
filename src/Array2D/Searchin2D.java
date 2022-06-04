package Array2D;
import java.util.*;

public class Searchin2D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int data = sc.nextInt();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(data == arr[i][j]) {
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }
        System.out.println("Not Found");

    }
}
