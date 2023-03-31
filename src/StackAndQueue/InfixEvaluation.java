package StackAndQueue;
import java.io.*;
import java.util.*;

/**
 * problem Infix evaluation
 * 1. You are given an infix expression.
 * 2. You are required to evaluate and print its value.
 *
 * CONSTRAIN
 * 1. Expression is balanced
 * 2. The only operators used are +, -, *, /
 * 3. Opening and closing brackets - () - are used to impact precedence of operations
 * 4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
 * 5. In two operators of equal precedence give preference to the one on left.
 * 6. All operands are single digit numbers.
 *
 * solved;
 * Author : sameer Ahmad
 * Date : 18/03/2023
 */

public class InfixEvaluation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code

        Stack<Integer> oprnd = new Stack<>();
        Stack<Character> optr = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '(' ){
                optr.push(ch);

            }else if(Character.isDigit(ch)){// to check whether the ch is digit or not
                oprnd.push(ch - '0'); // char to int

            }else if(ch == ')'){  // here we are handle the case when the close parenthesis came
                while(optr.peek() != '('){
                    char opr = optr.pop();
                    int v2 = oprnd.pop();
                    int v1 = oprnd.pop();
                    int val = operation(v1,v2,opr);

                    oprnd.push(val);
                }
                optr.pop(); // doing one extra pop for pop of open parenthesis

                // if there is some operator came and stack is not empty
                //and top of stack is not an open brace
                // and have higher precedence in stack than ch then do operation
            }else if(ch == '-' || ch =='+' || ch == '*'|| ch =='/' ){
                while(optr.size() > 0 && optr.peek() != '(' && precedence(ch) <= precedence(optr.peek())){
                    char opr = optr.pop();
                    int v2 = oprnd.pop();
                    int v1 = oprnd.pop();
                    int val = operation(v1,v2,opr);

                    oprnd.push(val);
                }
                optr.push(ch);
            }
        }
        // when every thing is pushed without any pop then do this
        while(optr.size() != 0){
            char opr = optr.pop();
            int v2 = oprnd.pop();
            int v1 = oprnd.pop();
            int val = operation(v1,v2,opr);

            oprnd.push(val);

        }
        System.out.println(oprnd.peek());

    }
    // here I look at the precedence of operator
    public static int precedence( char optr){
        if(optr == '-'){
            return 1;
        }else if(optr == '+'){
            return 1;
        }else if(optr == '*'){
            return 2;
        }else{
            return 2;
        }
    }

    // operation is done here
    public static int operation(int v1,int v2, char optr){
        if(optr == '-'){
            return v1 - v2;
        }else if(optr == '+'){
            return v1 + v2;
        }else if(optr == '*'){
            return v1 * v2;
        }else{
            return v1 / v2;
        }

    }

}
