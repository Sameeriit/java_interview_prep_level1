package recursion.backtracking;
import java.util.*;

/**
 * problem print target sum subsets
 * solution
 * Author : Sameer Ahmad
 * date: 23/06/2022
 *
 */

public class PrintTargetSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        print_Target_Subset_Sum(arr,0,"",0,tar);

    }
    // set is the subset
    // sos is sum of subset
    // tar is target

    public static void print_Target_Subset_Sum(int[]arr,int idx,String set,int sos,int tar){

        if(idx == arr.length){
            if(sos == tar){
                System.out.println(set + ".");
            }

            return;
        }


        print_Target_Subset_Sum(arr,idx + 1, set + arr[idx]+", ",sos + arr[idx], tar);
        print_Target_Subset_Sum(arr,idx + 1,set,sos,tar);
    }
}
