package recursion.basics;
import java.util.*;

public class FirstIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        int data = sc.nextInt();
        int result = first_index(a,0,data);
        System.out.println(result);
    }

    public static int first_index(int[]arr,int idx,int data){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == data){
            return idx;
        }else {
            int fi = first_index(arr, idx + 1, data);

            return fi ;
        }


    }
}
