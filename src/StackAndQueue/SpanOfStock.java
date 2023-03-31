package StackAndQueue;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * porblem SpanOfStock
 * 1. You are given a number n, representing the size of array a.
 * 2. You are given n numbers, representing the prices of a share on n days.
 * 3. You are required to find the stock span for n days.
 * 4. Stock span is defined as the number of days passed between
 * the current day and the first day before today when price was higher than today.
 * solution :done;
 * Author: sameer ahmad
 * date : 15/02/2023
 */

public class SpanOfStock {
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

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr){
        // solve
        int[]span = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;

        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                span[i] = i + 1;
            }else{
                span[i] = i - st.peek();
            }
            st.push(i);
        }


        return span;
    }
}
