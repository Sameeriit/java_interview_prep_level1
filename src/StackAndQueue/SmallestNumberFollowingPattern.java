package StackAndQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. You are given a pattern of up to 8 length containing characters 'i' and 'd'.
 * 2. 'd' stands for decreasing and 'i' stands for increasing
 * 3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that
 * the digit decreases following a d and increases following an i.
 *
 * e.g.
 * d -> 21
 * i -> 12
 * ddd -> 4321
 * iii -> 1234
 * dddiddd -> 43218765
 * iiddd -> 126543
 *
 * solved:
 * Author: Sameer Ahmad
 * date: 7/4/2023
 */


public class SmallestNumberFollowingPattern {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'd') {
                st.push(num);
                num++;
            }else{
                st.push(num);
                num++;
                while(st.size() > 0 ){
                    System.out.print(st.pop());
                }
            }
        }
        st.push(num);
        while(st.size() > 0){
            System.out.print(st.pop());
        }
    }
}
