package StackAndQueue;

import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * problem  the Largest area histogram.
 * 1. You are given a number n, representing the size of array a.
 * 2. You are given n numbers, representing the height of bars in a bar chart.
 * 3. You are required to find and print the area of  the largest rectangle in the histogram.
 *
 * e.g.
 * for the array [6 2 5 4 5 1 6] -> 12
 * solved;
 * Author : Sameer Ahmad
 * date: 14/3/2023
 */

public class LargestAreaHistogram {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //right boundary
        int[] rb = new int[arr.length]; //next smaller element from right
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;

        for(int i = arr.length -2; i >= 0; i--){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                rb[i] = arr.length;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }

        // left boundary
        int[] lb = new int[arr.length]; //next smaller element from left
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;

        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }


        //area
        int maxArea = 0;
        for(int i = 0; i < arr.length; i++){
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if(area > maxArea){
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }
}
