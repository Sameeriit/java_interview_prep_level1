package Array2D;
import java.util.*;

public class RingRotate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int shell = sc.nextInt();
        int rotation = sc.nextInt();

        rotateShell(arr,shell,rotation);
        display(arr);

    }
    public static void rotateShell(int[][] arr,int s, int r){
        int[] Oned = fillOnedFromShell(arr,s);
        rotateOned(Oned,r);              // Here we pass oned arry which i fill by shell
        fillShellFromOned(arr,s,Oned);
    }


    public static void rotateOned(int[]arr,int r){
        r = r % arr.length;
        if(r < 0){
            r += arr.length;
        }

        //first part
        reverse(arr, 0,arr.length - (r +1));

        //second part
        reverse(arr, arr.length-r,arr.length-1);
        //complete
        reverse(arr, 0,arr.length-1);

    }

    public static void reverse(int[]arr, int li, int ri){
        while(li < ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
        }
        li++;
        ri--;

    }
    public static int[] fillOnedFromShell(int[][] arr, int s){

        int minr  = s -1;
        int minc  = s -1;

        int maxr = arr.length - s;
        int maxc = arr[0].length -s;
        int size = 2*(maxr - minr + maxc - minc ); // lw + bw + rw + tw -4
                                                   //((maxr - minr +1) + (maxc - minc +1) + (maxr - minr + 1) + (maxc - minc +1) -4)
        int[] Oned = new int[size];

        int idx = 0;

        //lw
        for(int i = minr,j = minc; i <= maxr; i++){
            Oned[idx] = arr[i][j];
            idx++;

        }
        minc++;
        //bw
        for(int i = maxr,j = minc; j <= maxc; j++){
            Oned[idx] = arr[i][j];
            idx++;
        }
        maxr--;

        //rw
        for(int i = maxr,j = maxc; i >= minr; i--){
            Oned[idx] = arr[i][j];
            idx++;
        }
        maxc--;
        //tw
        for(int i = minr,j = maxc; j >= minc; j--){
            Oned[idx] = arr[i][j];
            idx++;
        }

        return Oned;

    }

    public static void fillShellFromOned(int[][]arr,int s, int[]Oned){

        int minr  = s - 1;
        int minc  = s - 1;

        int maxr = arr.length - s;
        int maxc = arr[0].length - s;


        int idx = 0;

        //lw
        for(int i = minr,j = minc; i <= maxr; i++){
            arr[i][j] =Oned[idx];
            idx++;

        }
        minc++;
        //bw
        for(int i = maxr,j = minc; j <= maxc; j++){
            arr[i][j] =Oned[idx];
            idx++;
        }
        maxr--;

        //rw
        for(int i = maxr,j = maxc; i >= minr; i--){
            arr[i][j] =Oned[idx];
            idx++;
        }
        maxc--;
        //tw
        for(int i = minr,j = maxc; j >= minc; j--){
            arr[i][j] =Oned[idx];
            idx++;
        }

    }

    public static void display(int[][]arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
