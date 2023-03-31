package StackAndQueue;
import java.util.*;

/**
 * problem balanced bracket of an expression
 * solution :done;
 * Author: sameer ahmad
 * date : 15/02/2023
 */

public class BalanceBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch =='['){
                st.push(ch);
            }else if (ch == ')'){
                Boolean val = handler(st,'(');
                if(val == false){
                    System.out.println(val);
                    return;
                }

            }else if(ch == '}'){
                Boolean val = handler(st,'{');
                if(val == false){
                    System.out.println(val);
                    return;
                }

            }else if(ch == ']'){
                Boolean val = handler(st,'[');
                if(val == false){
                    System.out.println(val);
                    return;
                }

            }else { // ignore the other character

            }
        }
        // check if opening bracket is greater
        if(st.size() == 0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

    }

    public static Boolean handler(Stack<Character> st, char correspondence_ch){
        // check if closing bracket is greater
        if(st.size() == 0){
            return false ;
        }else if(st.peek() != correspondence_ch){
            return false ;
        }else {
            st.pop();
            return true;
        }
    }

}
