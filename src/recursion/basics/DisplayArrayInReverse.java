package recursion.basics;
import java.util.*;

/**
 * problem display array in reverse
 * solution
 * Author : Sameer Ahmad
 * date : 08/06/2022
 */

public class DisplayArrayInReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]a = new int[n];
        for(int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        ReverseArray(a,0);
    }
    public static void ReverseArray(int[]arr, int idx){
        if(idx == arr.length){
            return;
        }
        ReverseArray(arr,idx+1);
        System.out.print(arr[idx]+" ");

    }
}
