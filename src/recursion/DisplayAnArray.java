package recursion;
import java.util.*;

/**
 * problem print all element of an array
 * solution
 * Author : Sameer Ahmad
 * date : 8/06/2022
 */

public class DisplayAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]a = new int[n];
        for(int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        display(a,0);

    }
    public static void display(int[]arr,int idx){
        if(idx == arr.length){
            return;
        }
        System.out.print(arr[idx] +" ");
        display(arr,idx + 1);

    }
}
