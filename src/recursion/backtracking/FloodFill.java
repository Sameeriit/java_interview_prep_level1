package recursion.backtracking;
import java.util.*;

/**
 * problem flood fill of a maze
 * solution
 * Author : Sameer Ahmad
 * date : 20/06/2022
 */

public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        boolean [][] visited = new boolean[n][m];
        flood_fill(arr,0,0,"",visited);

    }
     // asf-> answer so far
    public static void flood_fill(int[][]arr,int sr,int sc,String asf,boolean[][]visited){
//        boolean[sr][sc] visited = true;

        if(sr < 0 || sc < 0){       // out of boundary left and top
            return;
        }else if(sr == arr.length || sc == arr[0].length ) {   //out of boundary right and down
            return;
        }else if(arr[sr][sc] == 1 || visited[sr][sc] == true){   // obstacles
            return;

        }
        if(sr == arr.length - 1 && sc == arr[0].length - 1) {  // at final position
            System.out.println(asf);
            return;

        }
             visited[sr][sc] = true;
            //top
            flood_fill(arr, sr - 1, sc, asf + "",visited);

            //left
            flood_fill(arr, sr , sc -1, asf + "l",visited);


            // down
            flood_fill(arr, sr + 1, sc, asf + "d",visited);

            //right
            flood_fill(arr, sr, sc + 1, asf + "r",visited);

            visited[sr][sc] = false;


    }
}
