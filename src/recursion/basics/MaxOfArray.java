package recursion.basics;
import java.util.*;

/**
 * problem Max of an array
 * solution
 * Author : Sameer Ahmad
 * date : 08/06/2022
 */

public class MaxOfArray {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[]a = new int[n];
      for(int i = 0; i < a.length; i++){
          a[i] = sc.nextInt();
      }
       int result = MaxArray(a,0);
      System.out.println(result);

    }

    public static int MaxArray(int[]arr, int idx){
        if(idx == arr.length - 1){
            return arr[idx];
        }

        int max_in_smaller_array =  MaxArray(arr,idx + 1);
         if(max_in_smaller_array > arr[idx]){
            return max_in_smaller_array;
         }else{
            return arr[idx];
        }
    }
}
