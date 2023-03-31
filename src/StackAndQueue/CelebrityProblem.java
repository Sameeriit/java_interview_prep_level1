package StackAndQueue;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * problem
 * 1. You are given a number n, representing the number of people in a party.
 * 2. You are given n strings of n length containing 0's and 1's
 * 3. If there is a '1' in ith row, jth spot, then person i knows about person j.
 * 4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
 * 5. If there is a celebrity print it's index otherwise print "none".
 *
 * Note -> There can be only one celebrity. Think why?
 * solved ;
 * Author : Sameer Ahmad
 * date: 31-03-2023
 */

public class CelebrityProblem {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < arr.length; i++){
            String line = br.readLine();
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = line.charAt(j) - '0'; // convert into integer

            }
        }
        findcelebrity(arr);

    }
    public static void findcelebrity(int[][]arr){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            st.push(i);
        }

        while(st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                //if i  knows j  then i can't be celebrity
                st.push(j);
            } else {
                //if i doesn't know the j means j can't be celebrity
                st.push(i);
            }
        }
        // pot -> potential celebrity
        int pot = st.pop();
        for(int i = 0 ; i < arr.length; i++){
            if(pot != i){
                if(arr[pot][i] == 1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);

    }

}
