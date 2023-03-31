package StackAndQueue;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

/**
 * problem
 * 1. You are given a prefix expression.
 * 2. You are required to evaluate it and print its value.
 * 3. You are required to convert it to infix and print it.
 * 4. You are required to convert it to postfix and print it.
 *
 * Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
 * solved:
 * Author : Sameer Ahmad
 * date: 31/03/2023
 */

public class PrefixEvalutionAndConversion {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> vs = new Stack<>();
        Stack<String>  is = new Stack<>();
        Stack<String>  ps = new Stack<>();

        for (int i = exp.length() -1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if(ch == '+'|| ch == '-'|| ch == '*' || ch =='/'){
                int v1 = vs.pop();
                int v2 = vs.pop();
                int val = operation(v1,v2,ch);
                vs.push(val);

                String isv1 = is.pop();
                String isv2 = is.pop();
                String isval = "(" + isv1 + ch + isv2 + ")";
                is.push(isval);

                String psv1 = ps.pop();
                String psv2 = ps.pop();
                String psval = psv1 + psv2 + ch;
                ps.push(psval);
            }else{
                vs.push(ch - '0');
                is.push(ch + "");
                ps.push(ch + "");

            }
        }
        System.out.println(vs.pop());
        System.out.println(is.pop());
        System.out.println(ps.pop());
    }
    public static int operation(int v1,int v2,char ch){
        if(ch == '+'){
            return  v1 + v2;
        }else if(ch == '-'){
            return v1 - v2;
        }else if(ch == '*'){
            return v1 * v2;
        }else{
            return v1 / v2;
        }
    }
}
