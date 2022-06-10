package recursion;
import java.util.*;

/**
 * problem print last index where data present
 * solution
 * Author : Sameer Ahmad
 * date : 08/06/2022
 */

public class LastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        int result = last_index(a,0,data);
        System.out.println(result);
    }

    public static int last_index(int[]arr, int idx, int data){
        if(idx == arr.length){
            return -1;
        }

        int liisa = last_index(arr,idx + 1, data); // liisa = last index in smaller array
        if(liisa == -1) {
            if (arr[idx] == data) {
                return idx;
            } else {
                return liisa;
            }
        }else{
            return liisa;
        }
    }
}
