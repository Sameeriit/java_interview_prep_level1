package StackAndQueue;
import java.util.*;
import java.io.*;
/**
 * porblem duplicate bracket of an expresion
 * solution :done;
 * Author: sameer ahmad
 * date : 18/10/2022
 */

public class DuplicateBrackect {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                if (st.peek() == '(') {
                    System.out.println(true);
                    return;
                }else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                }
                st.pop();

            }else{
                st.push(ch);
            }

        }
        System.out.println(false);
    }

}
