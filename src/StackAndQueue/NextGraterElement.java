package StackAndQueue;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * porblem NextGraterElement
 * solution :done;
 * Author: sameer ahmad
 * date : 15/02/2023
 */

public class NextGraterElement {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }
    //approch 1
    public static int[] solve(int[] arr){
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length - 1]);
        nge[arr.length - 1] = -1;
        for(int i = arr.length-2; i >= 0; i--){
            while(st.size() > 0 && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }


        return nge;
    }

   //approch 2
   /*
    public static int[] solve(int[] arr){
        // solve
        int[] nge = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[i] >= arr[st.peek()] ){
                int position = st.peek();
                nge[position] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0){
            int position = st.peek();
            nge[position] = -1;
            st.pop();
        }

        return nge;
    }
    */

}
